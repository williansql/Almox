package fofaps.apps.almox.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestExceptions extends Exception {

  public BadRequestExceptions(String message) {
    super(message);
  }

  public BadRequestExceptions(String message, Throwable cause) {
    super(message, cause);
  }
}
