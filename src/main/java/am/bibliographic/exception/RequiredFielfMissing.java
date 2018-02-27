package am.bibliographic.exception;

public class RequiredFielfMissing extends DAOException {
    public RequiredFielfMissing() {
        this("Required filed is missing");
    }

    public RequiredFielfMissing(String message) {
        super(message);
    }

    public RequiredFielfMissing(String message, Throwable cause) {
        super(message, cause);
    }
}