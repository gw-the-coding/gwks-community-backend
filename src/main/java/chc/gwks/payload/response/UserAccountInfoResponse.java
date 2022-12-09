package chc.gwks.payload.response;

import chc.gwks.code.AuthorizationCode;
import chc.gwks.code.CommunityCode;
import chc.gwks.code.Platform;
import chc.gwks.code.UserState;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserAccountInfoResponse {

    private Long userSysId;

    private String name;

    private String nickName;

    private String profileImage;

    private String email;

    private String birthyear;

    private Platform platform;

    private CommunityCode community;

    private AuthorizationCode authority;

    private UserState state;

    private LocalDateTime createdAt;

    private LocalDateTime lastModifiedAt;

}
