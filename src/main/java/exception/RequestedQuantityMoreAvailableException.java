package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestedQuantityMoreAvailableException extends RuntimeException {
    public RequestedQuantityMoreAvailableException() {
    }

    public RequestedQuantityMoreAvailableException(String message) {
        super(message);
    }

    public RequestedQuantityMoreAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestedQuantityMoreAvailableException(Throwable cause) {
        super(cause);
    }

    public RequestedQuantityMoreAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
