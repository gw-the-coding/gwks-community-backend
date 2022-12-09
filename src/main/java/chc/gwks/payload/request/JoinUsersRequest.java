package chc.gwks.payload.request;

import chc.gwks.code.CommunityCode;
import lombok.Data;

@Data
public class JoinUsersRequest {

    private String name;

    private String nickName;

    private String email;

    private CommunityCode community;

    private String birthyear;

}
