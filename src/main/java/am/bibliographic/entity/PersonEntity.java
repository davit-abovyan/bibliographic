package am.bibliographic.entity;

import java.util.Objects;

public class PersonEntity implements Entity{

    private int id;
    private String nameInitialArm;
    private String nameInitialRus;
    private String nameInitialEng;
    private String nameFinalArm;
    private String nameFinalRus;
    private String nameFinalEng;
    private boolean reviewState;

    public PersonEntity() {
    }

    public int getId() {
        return id;
    }

    public PersonEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getNameInitialArm() {
        return nameInitialArm;
    }

    public PersonEntity setNameInitialArm(String nameInitialArm) {
        this.nameInitialArm = nameInitialArm;
        return this;
    }

    public String getNameInitialRus() {
        return nameInitialRus;
    }

    public PersonEntity setNameInitialRus(String nameInitialRus) {
        this.nameInitialRus = nameInitialRus;
        return this;
    }

    public String getNameInitialEng() {
        return nameInitialEng;
    }

    public PersonEntity setNameInitialEng(String nameInitialEng) {
        this.nameInitialEng = nameInitialEng;
        return this;
    }

    public String getNameFinalArm() {
        return nameFinalArm;
    }

    public PersonEntity setNameFinalArm(String nameFinalArm) {
        this.nameFinalArm = nameFinalArm;
        return this;
    }

    public String getNameFinalRus() {
        return nameFinalRus;
    }

    public PersonEntity setNameFinalRus(String nameFinalRus) {
        this.nameFinalRus = nameFinalRus;
        return this;
    }

    public String getNameFinalEng() {
        return nameFinalEng;
    }

    public PersonEntity setNameFinalEng(String nameFinalEng) {
        this.nameFinalEng = nameFinalEng;
        return this;
    }

    public boolean isReviewState() {
        return reviewState;
    }

    public PersonEntity setReviewState(boolean reviewState) {
        this.reviewState = reviewState;
        return this;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if(object == this) return true;
        if(!(object instanceof PersonEntity)) return false;
        PersonEntity that = (PersonEntity) object;
        return Objects.equals(nameInitialArm, that.getNameInitialArm()) &&
                Objects.equals(nameInitialRus, that.getNameInitialRus()) &&
                Objects.equals(nameInitialEng, that.getNameInitialEng()) &&
                Objects.equals(nameFinalArm, that.getNameFinalArm()) &&
                Objects.equals(nameFinalRus, that.getNameFinalRus()) &&
                Objects.equals(nameFinalEng, that.getNameFinalEng()) &&
                Objects.equals(reviewState, that.isReviewState());
    }
}
