package togedog.server.domain.reply.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import togedog.server.domain.reply.service.dto.request.ReplyServiceCreateApiRequest;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class ReplyCreateApiRequest {


    private Long feedId;
    private String content;
    private Boolean fix;


    public ReplyServiceCreateApiRequest toCreateServiceApiRequest() {
        return ReplyServiceCreateApiRequest.builder()
                .content(content)
                .fix(fix)
                .build();

    }
}