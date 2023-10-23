package fofaps.apps.almox.utils.exceptions;

public class Exception extends java.lang.Exception {

  public Exception(String message) {

    super(message, null, false, false);
  }

  public Exception(String message, Throwable cause) {

    super(message, cause, false, false);
  }
}
