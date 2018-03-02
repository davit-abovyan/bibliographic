package am.bibliographic.entity;

public class OperatorEntity implements IdEntity {

    private int id;
    private String name;
    private boolean reviewer;

    public OperatorEntity() {}

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

    public OperatorEntity setReviewer(boolean reviewer) {
        this.reviewer = reviewer;
        return this;
    }
}