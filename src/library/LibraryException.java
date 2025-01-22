package library;
    /*
    - Hata durumları için özel exception'lar tanımlayın:
  - BookNotFoundException
  - MemberNotFoundException
  - BookNotAvailableException
  - MaxBooksExceededException
     */

public class LibraryException {

    // BookNotFoundException
    public static class BookNotFoundException extends Exception {
        public BookNotFoundException(String message) {
            super(message);
        }
    }

    // MemberNotFoundException
    public static class MemberNotFoundException extends Exception {
        public MemberNotFoundException(String message) {
            super(message);
        }
    }

    // BookNotAvailableException
    public static class BookNotAvailableException extends Exception {
        public BookNotAvailableException(String message) {
            super(message);
        }
    }

    // MaxBooksExceededException
    public static class MaxBooksExceededException extends Exception {
        public MaxBooksExceededException(String message) {
            super(message);
        }
    }

    // Method to trigger exception handling
    public static void handleException(String exceptionType, String message) throws Exception {
        switch (exceptionType) {
            case "BookNotFound":
                throw new BookNotFoundException(message);
            case "MemberNotFound":
                throw new MemberNotFoundException(message);
            case "BookNotAvailable":
                throw new BookNotAvailableException(message);
            case "MaxBooksExceeded":
                throw new MaxBooksExceededException(message);
            default:
                throw new Exception("Unknown exception type");
        }
    }
}
