package togedog.server.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import togedog.server.domain.member.dto.MemberDto;
import togedog.server.domain.member.service.MemberService;
import togedog.server.global.mail.MailService;

@RestController
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MailService mailService;
    private final MemberService memberService;

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<?> signupMember(@RequestBody MemberDto memberDto){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 로그인 => security 에서 처리
    @PostMapping("/login")
    public ResponseEntity<?> loginMember(@RequestBody MemberDto memberDto){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping()
    public String getMember(@RequestParam("par") String par){

        return "param = par :" + par;
    }




    @PostMapping("/emails/verification-requests")
    public ResponseEntity sendMessage(@RequestParam("email") String email) {
        memberService.sendCodeToEmail(email);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/emails/verifications")
//    public ResponseEntity verificationEmail(@RequestParam("email") String email,
//                                            @RequestParam("code") String authCode) {
//        EmailVerificationResult response = memberService.verifiedCode(email, authCode);
//
//        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
//    }



}
