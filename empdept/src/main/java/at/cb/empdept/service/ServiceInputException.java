package at.cb.empdept.service;

public class ServiceInputException extends Exception{
    public ServiceInputException() {
    }

    public ServiceInputException(String message) {
        super(message);
    }

    public ServiceInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceInputException(Throwable cause) {
        super(cause);
    }

    public ServiceInputException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
