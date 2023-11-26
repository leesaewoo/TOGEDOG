package togedog.server.domain.feedbookmark.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import togedog.server.domain.feed.entity.Feed;
import togedog.server.domain.feed.repository.FeedRepository;
import togedog.server.domain.feed.service.FeedService;
import togedog.server.domain.feedbookmark.entity.FeedBookmark;
import togedog.server.domain.feedbookmark.repository.FeedBookmarkRepository;
import togedog.server.domain.feedlike.entity.FeedLike;
import togedog.server.domain.member.entity.Member;
import togedog.server.domain.member.repository.MemberRepository;
import togedog.server.global.exception.businessexception.feedexception.FeedNotFoundException;
import togedog.server.global.exception.businessexception.memberexception.MemberNotFoundException;
import togedog.server.global.exception.businessexception.memberexception.MemberNotLoginException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedBookmarkService {


    private final FeedBookmarkRepository feedBookmarkRepository;
    private final MemberRepository memberRepository;
    private final FeedRepository feedRepository;


    public void bookmarkFeed(Long feedId) {

        Long loginMemberId = 123L;

        if (loginMemberId == null) {
            throw new MemberNotLoginException();
        }

        Optional<Member> memberOptional = memberRepository.findById(loginMemberId);
        Member member = memberOptional.orElseThrow(MemberNotFoundException::new);

        Optional<Feed> feedOptional = feedRepository.findById(feedId);
        Feed feed = feedOptional.orElseThrow(FeedNotFoundException::new);

        Optional<FeedBookmark> alreadyBookmark = feedBookmarkRepository.findByMemberAndFeed(member, feed);


        if (alreadyBookmark.isPresent()) { // 현재 로직은 있으면 delete or 객체 생성인데 다음엔 타입으로 받고 내리고 올리자
            feedBookmarkRepository.delete(alreadyBookmark.get());

        } else {
            FeedBookmark newFeedBook = FeedBookmark.builder()
                    .member(member)
                    .feed(feed)
                    .build();

            feedBookmarkRepository.save(newFeedBook);

        }
    }
}