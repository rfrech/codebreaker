package edu.cnm.deepdive.codebreaker.model;

/**
 *  Guess contains invalid characters
 */
public class IllegalGuessCharacterException extends IllegalArgumentException {

  /**
   * exception
   */
  public IllegalGuessCharacterException() {
  }

  /**
   *
   * @param message returning guess was invalid
   */
  public IllegalGuessCharacterException(String message) {
    super(message);
  }

  /**
   *
   * @param message
   * @param cause
   */
  public IllegalGuessCharacterException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   *
   * @param cause
   */
  public IllegalGuessCharacterException(Throwable cause) {
    super(cause);
  }

}
