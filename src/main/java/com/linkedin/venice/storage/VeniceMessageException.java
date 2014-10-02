package com.linkedin.venice.storage;

/**
 * Custom Exception for Venice Storage Related Issues.
 * Currently everything is inherited from the superclass.
 */
public class VeniceMessageException extends Exception {

  public VeniceMessageException(String message) {
    super(message);
  }

  public VeniceMessageException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public String getMessage() {
    return super.getMessage();
  }

}
