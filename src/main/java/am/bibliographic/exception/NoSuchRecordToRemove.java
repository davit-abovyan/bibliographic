package am.bibliographic.exception;

public class NoSuchRecordToRemove extends DAOException {
    public NoSuchRecordToRemove() {

    }

    public NoSuchRecordToRemove(String message) {
        super(message);
    }

    public NoSuchRecordToRemove(String message, Throwable cause) {
        super(message, cause);
    }
}