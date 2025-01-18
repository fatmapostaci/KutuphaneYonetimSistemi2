package mertay.exceptionsclasses;

public class Parent_Library_Ex extends RuntimeException {

  public Parent_Library_Ex(String message) {
    super(message);
  }

  public Parent_Library_Ex(String message, Throwable cause) {
    super(message, cause);
  }
}
