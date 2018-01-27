package am.bibliographic.entity;

public class ScienceFieldEntity implements Entity{
    private int id;
    private String nameArm;
    private String nameRus;
    private String nameEng;

    public int getId() {
        return id;
    }

    public ScienceFieldEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getNameArm() {
        return nameArm;
    }

    public ScienceFieldEntity setNameArm(String nameArm) {
        this.nameArm = nameArm;
        return this;
    }

    public String getNameRus() {
        return nameRus;
    }

    public ScienceFieldEntity setNameRus(String nameRus) {
        this.nameRus = nameRus;
        return this;
    }

    public String getNameEng() {
        return nameEng;
    }

    public ScienceFieldEntity setNameEng(String nameEng) {
        this.nameEng = nameEng;
        return this;
    }

    public ScienceFieldEntity() {
    }

    public ScienceFieldEntity(String nameArm, String nameRus, String nameEng) {
        this.nameArm = nameArm;
        this.nameRus = nameRus;
        this.nameEng = nameEng;
    }
}
