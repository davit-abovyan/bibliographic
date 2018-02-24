package am.bibliographic.entity;

public class BohJournalEntity implements MultyIdEntity{

    private int journalId;
    private int bohId;

    public BohJournalEntity() {}

    // full constructor
    public BohJournalEntity(int bohId, int journalId) {
        this.bohId = bohId;
        this.journalId = journalId;
    }

    public int getJournalId() {
        return journalId;
    }

    public BohJournalEntity setJournalId(int journalId) {
        this.journalId = journalId;
        return this;
    }

    public int getBohId() {
        return bohId;
    }

    public BohJournalEntity setBohId(int bohId) {
        this.bohId = bohId;
        return this;
    }


}
