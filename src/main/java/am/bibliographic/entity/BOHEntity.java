package am.bibliographic.entity;

public class BOHEntity implements IdEntity{

    private int id;
    private String name;

    public BOHEntity() {}

    public int getId() {
        return id;
    }

    public BOHEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BOHEntity setName(String name) {
        this.name = name;
        return this;
    }
}
