package tci.demo.week3;

public class NonUniqueNameException extends Throwable {

    public NonUniqueNameException() {
    }

    public NonUniqueNameException(String message) {
        super(message);
    }

    public NonUniqueNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonUniqueNameException(Throwable cause) {
        super(cause);
    }

    public NonUniqueNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
