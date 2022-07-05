package exception;

public class InsertException extends Exception {

  public InsertException(String message, String... args) {
    super(String.format(message, (Object[]) args));
  }

}


