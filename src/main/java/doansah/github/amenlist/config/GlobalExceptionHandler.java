package doansah.github.amenlist.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // testing global exception handler
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), LocalTime.now().toString());

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    // final 'catch-all' exception: Handle Default and Unknown Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), LocalTime.now().toString());
        return ResponseEntity.badRequest().body(errorResponse);

    }


}
