package am.bibliographic.entity;

public class OperatorEntity implements IdEntity{
    private int id;
    private String name;
    private boolean isReviewer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_reviewer() {
        return isReviewer;
    }

    public void setIs_reviewer(boolean isReviewer) {
        this.isReviewer = isReviewer;
    }

    public OperatorEntity() {
    }

    public OperatorEntity(String name, boolean isReviewer) {
        this.name = name;
        this.isReviewer = isReviewer;
    }
}