package chc.gwks.service;

import chc.gwks.code.InternalResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseService<T> {

    private String resultCode;

    private String message;

    private T data;

    public ResponseService(InternalResultCode code) {
        this.resultCode = code.getResultCode();
        this.message = code.getMessage();
    }

    public ResponseService(InternalResultCode code, T data) {
        this.resultCode = code.getResultCode();
        this.message = code.getMessage();
        this.data = data;
    }
}
