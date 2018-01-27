package am.bibliographic.entity;

public class BOHEntity implements Entity{
    private int id;
    private String name;

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

    public BOHEntity() {
    }

    public BOHEntity(String name) {
        this.name = name;
    }
}
