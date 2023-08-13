package cw_2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class BlockException extends RuntimeException {
    public BlockException() {
    }

    public BlockException(String message) {
        super(message);
    }

    public BlockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlockException(Throwable cause) {
        super(cause);
    }

    public BlockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
