package am.bibliographic.entity;

import am.bibliographic.constants.Country;
import am.bibliographic.constants.Language;
import am.bibliographic.exception.RequiredFielfMissing;

public class JournalEntity implements IdEntity{

    private int id;
    private String code;
    private int operatorId;
    private String nameArm;
    private String nameRus;
    private String nameEng;
    private String fullNameArm;
    private String fullNameRus;
    private String fullNameEng;
    private String ISSNPrint;
    private String ISBN;
    private String founderArm;
    private String publisherArm;
    private String publisherRus;
    private String publisherEng;
    private String phone;
    private String fax;
    private String email;
    private String website;
    private Country country;
    private String city;
    private String address;
    private int frequency;
    private int language;
    private String journalCategory;
    private boolean reviewed;
    private boolean inProgress;
    private String startYear;
    private int editor;
    private String descriptionArm;
    private String descriptionRus;
    private String descriptionEng;
    private int scienceFieldId;
    private String cover;
    private boolean type;
    private int indexedLibraries;

    public JournalEntity() {}

    public int getIndexedLibraries() {
        return indexedLibraries;
    }

    public JournalEntity setIndexedLibraries(int indexedLibraries) {
        this.indexedLibraries = indexedLibraries;
        return this;
    }

    public String getCode() {
        return code;
    }

    public JournalEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public int getId() {
        return id;
    }

    public JournalEntity setId(int id) {
        this.id = id;
        return this;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public JournalEntity setOperatorId(int operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public String getNameArm() {
        return nameArm;
    }

    public JournalEntity setNameArm(String nameArm) {
        this.nameArm = nameArm;
        return this;
    }

    public String getNameRus() {
        return nameRus;
    }

    public JournalEntity setNameRus(String nameRus) {
        this.nameRus = nameRus;
        return this;
    }

    public String getNameEng() {
        return nameEng;
    }

    public JournalEntity setNameEng(String nameEng) {
        this.nameEng = nameEng;
        return this;
    }

    public String getFullNameArm() {
        return fullNameArm;
    }

    public JournalEntity setFullNameArm(String fullNameArm) {
        this.fullNameArm = fullNameArm;
        return this;
    }

    public String getFullNameRus() {
        return fullNameRus;
    }

    public JournalEntity setFullNameRus(String fullNameRus) {
        this.fullNameRus = fullNameRus;
        return this;
    }

    public String getFullNameEng() {
        return fullNameEng;
    }

    public JournalEntity setFullNameEng(String fullNameEng) {
        this.fullNameEng = fullNameEng;
        return this;
    }

    public String getISSNPrint() {
        return ISSNPrint;
    }

    public JournalEntity setISSNPrint(String ISSNPrint) {
        this.ISSNPrint = ISSNPrint;
        return this;
    }

    public String getISBN() {
        return ISBN;
    }

    public JournalEntity setISBN(String ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    public String getFounderArm() {
        return founderArm;
    }

    public JournalEntity setFounderArm(String founderArm) {
        this.founderArm = founderArm;
        return this;
    }

    public String getPublisherArm() {
        return publisherArm;
    }

    public JournalEntity setPublisherArm(String publisherArm) {
        this.publisherArm = publisherArm;
        return this;
    }

    public String getPublisherRus() {
        return publisherRus;
    }

    public JournalEntity setPublisherRus(String publisherRus) {
        this.publisherRus = publisherRus;
        return this;
    }

    public String getPublisherEng() {
        return publisherEng;
    }

    public JournalEntity setPublisherEng(String publisherEng) {
        this.publisherEng = publisherEng;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public JournalEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public JournalEntity setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public JournalEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public JournalEntity setWebsite(String website) {
        this.website = website;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public JournalEntity setCountry(String country) {
        this.country = "".equals(country) ? Country.ARM : Country.valueOf(country);
        return this;
    }

    public String getCity() {
        return city;
    }

    public JournalEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public JournalEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getFrequency() {
        return frequency;
    }

    public JournalEntity setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public int getLanguage() {
        return language;
    }

    public JournalEntity setLanguage(int language) {
        this.language = language;
        return this;
    }

    public String getJournalCategory() {
        return journalCategory;
    }

    public JournalEntity setJournalCategory(String journalCategory) {
        this.journalCategory = journalCategory;
        return this;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public JournalEntity setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
        return this;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public JournalEntity setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
        return this;
    }

    public String getStartYear() {
        return startYear;
    }

    public JournalEntity setStartYear(String startYear) {
        this.startYear = startYear;
        return this;
    }

    public int getEditor() {
        return editor;
    }

    public JournalEntity setEditor(int editor) {
        this.editor = editor;
        return this;
    }

    public String getDescriptionArm() {
        return descriptionArm;
    }

    public JournalEntity setDescriptionArm(String descriptionArm) {
        this.descriptionArm = descriptionArm;
        return this;
    }

    public String getDescriptionRus() {
        return descriptionRus;
    }

    public JournalEntity setDescriptionRus(String descriptionRus) {
        this.descriptionRus = descriptionRus;
        return this;
    }

    public String getDescriptionEng() {
        return descriptionEng;
    }

    public JournalEntity setDescriptionEng(String descriptionEng) {
        this.descriptionEng = descriptionEng;
        return this;
    }

    public int getScienceFieldId() {
        return scienceFieldId;
    }

    public JournalEntity setScienceFieldId(int scienceFieldId) {
        this.scienceFieldId = scienceFieldId;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public JournalEntity setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public boolean isType() {
        return type;
    }

    public JournalEntity setType(boolean type) {
        this.type = type;
        return this;
    }
}
