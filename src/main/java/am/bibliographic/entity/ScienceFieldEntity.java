package am.bibliographic.entity;

public class ScienceFieldEntity implements IdEntity {

    private int id;
    private String nameArm;
    private String nameRus;
    private String nameEng;

    public ScienceFieldEntity() {}

    // full constructor
    public ScienceFieldEntity(int id, String nameArm, String nameRus, String nameEng) {
        this.id = id;
        this.nameArm = nameArm;
        this.nameRus = nameRus;
        this.nameEng = nameEng;
    }

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
}
