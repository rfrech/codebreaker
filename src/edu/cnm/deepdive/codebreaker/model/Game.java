package edu.cnm.deepdive.codebreaker.model;

import edu.cnm.deepdive.codebreaker.model.Code.Guess;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *  Implementing game object which uses random code to create a list of guess.
 */
public class Game {

  private static final String BAD_GUESS_PATTERN_FORMAT = "^.*[^%s].*$";
  private static final String ILLEGAL_LENGTH_MESSAGE = "Invalid guess length: required=%d; provided=%d.";
  private static final String ILLEGAL_CHARACTER_MESSAGE = "Guess includes invalid characters: required=%s; provided=%s.";

  private final Code code;
  private final List<Guess> guesses;
  private final String pool;
  private final int length;
  private final String badGuessPattern;

  /**
   *
   * @param pool letters available
   * @param length length available
   * @param rng random
   */
  public Game(String pool, int length, Random rng) {
    code = new Code(pool, length, rng);
    guesses = new LinkedList<>();
    this.pool = pool;
    this.length = length;
    badGuessPattern = String.format(BAD_GUESS_PATTERN_FORMAT, pool);
  }

  /**
   *
   * @return returns code
   */
  public Code getCode() {
    return code;
  }

  /**
   *
   * @return returns list of guess
   */
  public List<Guess> getGuesses() {
    return Collections.unmodifiableList(guesses);
  }

  /**
   *
   * @return pool of characters
   */
  public String getPool() {
    return pool;
  }

  /** returns length of code
   *
   * @return
   */
  public int getLength() {
    return length;
  }

  /**
   *
   * @return number of guess made
   */
  public int getGuessCount() {
    return guesses.size();
  }

  /**
   *
   * @param text
   * @return valid guess
   * @throws IllegalGuessLengthException guess length didnt fit
   * @throws IllegalGuessCharacterException invalid character text
   */
  public Guess guess(String text)
      throws IllegalGuessLengthException, IllegalGuessCharacterException {
    if (text.length() != length) {
      throw new IllegalGuessLengthException(String.format(
          ILLEGAL_LENGTH_MESSAGE, length, text.length()));
    }
    if (text.matches(badGuessPattern)) {
      throw new IllegalGuessCharacterException(String.format(
          ILLEGAL_CHARACTER_MESSAGE, pool, text));
    }
    Guess guess = code.new Guess(text);
    guesses.add(guess);
    return guess;
  }

  /**
   * clears guesses
   */
  public void restart() {
    guesses.clear();
  }
}