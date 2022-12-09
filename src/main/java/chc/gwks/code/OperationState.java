package chc.gwks.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@ToString
public enum OperationState {
    ACTIVE("ACTIVE", "운영중"),
    CLOSED("CLOSED", "중지"),
    REMOVE("REMOVE", "삭제");

    private String code;
    private String description;

    OperationState(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
