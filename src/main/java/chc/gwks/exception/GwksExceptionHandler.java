package chc.gwks.exception;

import chc.gwks.code.InternalResultCode;
import chc.gwks.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GwksExceptionHandler {

    @ExceptionHandler(value = NotFoundUsersException.class)
    public ResponseEntity exception(NotFoundUsersException exception) {
        exception.printStackTrace();
        return ResponseEntity.ok()
                .body(new ResponseService(InternalResultCode.NOT_FOUND_USER));
    }

}
