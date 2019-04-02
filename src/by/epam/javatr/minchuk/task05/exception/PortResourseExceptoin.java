package by.epam.javatr.minchuk.task05.exception;

public class PortResourseExceptoin extends Exception {

    public PortResourseExceptoin() {
    }

    public PortResourseExceptoin(String message) {
        super(message);
    }

    public PortResourseExceptoin(String message, Throwable cause) {
        super(message, cause);
    }

    public PortResourseExceptoin(Throwable cause) {
        super(cause);
    }
}
