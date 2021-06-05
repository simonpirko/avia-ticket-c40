package by.tms.aviaticket.Exception;

public class UserDataException extends RuntimeException{
    public UserDataException() {
    }

    public UserDataException(String message) {
        super(message);
    }

    public UserDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
