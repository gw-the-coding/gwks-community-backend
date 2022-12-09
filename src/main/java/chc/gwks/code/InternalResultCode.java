package chc.gwks.code;

import lombok.Getter;

@Getter
public enum InternalResultCode {

    SUCCESS("0001", "Success"),
    BAD_REQUEST("1001", "Bad Request"),
    NOT_FOUND_DATA("1003", "Not Found Data. Please Check this your params"),
    NOT_FOUND_USER("1003", "Not Found User"),
    NOT_FOUND_ADS_CAMPAIGN("2002", "Not Found Ads Campaign"),
    UNDEFIND_CAMPAIGN_PROPOSE("2003", "Undefind Campaign Propose"),
    FACEBOOK("3001", "FacebookAPI is Not Success"),
    EXCEPTION("9999", "Exception");

    private String resultCode;
    private String message;

    InternalResultCode(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
