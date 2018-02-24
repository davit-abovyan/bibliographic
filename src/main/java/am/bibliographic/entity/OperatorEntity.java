package am.bibliographic.entity;

public class OperatorEntity implements IdEntity {

    private int id;
    private String name;
    private boolean reviewer;

    public OperatorEntity() {}

    // full constructor
    public OperatorEntity(int id, String name, boolean isReviewer) {
        this.id = id;
        this.name = name;
        this.reviewer = isReviewer;
    }

    public int getId() {
        return id;
    }

    public OperatorEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OperatorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isReviewer() {
        return reviewer;
    }

    public OperatorEntity setReviewer(boolean isReviewer) {
        this.reviewer = isReviewer;
        return this;
    }
}