package chc.gwks.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@ToString
public enum CommunityCode {
    NOT_YET("NOT_YET", "미정"),
    ONE("ONE", "1청년부"),
    TWO("TWO", "2청년부"),
    THREE("THREE", "3청년부"),
    MERRY_BRIDGE("MERRY_BRIDGE", "신혼브릿지");

    private String code;
    private String description;

    CommunityCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
