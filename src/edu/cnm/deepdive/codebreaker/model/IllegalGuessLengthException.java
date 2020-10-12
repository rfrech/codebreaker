package edu.cnm.deepdive.codebreaker.model;

/**
 * Indicates guess was bad length
 */
public class IllegalGuessLengthException extends IllegalArgumentException {

  /**
   * Exception that guess is bad length
   */
  public IllegalGuessLengthException() {
  }

  /**
   *
   * @param message message guess is bad length
   */
  public IllegalGuessLengthException(String message) {
    super(message);
  }

  /**
   *
   * @param message
   * @param cause
   */
  public IllegalGuessLengthException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * 
   * @param cause
   */
  public IllegalGuessLengthException(Throwable cause) {
    super(cause);
  }
}
