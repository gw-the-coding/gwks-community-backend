package chc.gwks.payload.response;

import chc.gwks.code.UserState;
import lombok.Data;

@Data
public class AuthenticationTokenResponse {

    private UserState state;

    private Long expiredAt;

    private String accessToken;

}
