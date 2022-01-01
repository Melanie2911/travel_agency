package fr.lernejo.prediction.exceptions;
import fr.lernejo.prediction.exceptions.UnknownCountryException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value=UnknownCountryException.class)
    public ResponseEntity<Object> exception(UnknownCountryException exception){
        return new ResponseEntity<>(exception.getMessage(),new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
    }

}
