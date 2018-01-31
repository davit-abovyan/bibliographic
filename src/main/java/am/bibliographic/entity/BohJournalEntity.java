package am.bibliographic.entity;

public class BohJournalEntity implements MultyIdEntity{
    private int journalId;
    private int bohId;

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public int getBohId() {
        return bohId;
    }

    public void setBohId(int bohId) {
        this.bohId = bohId;
    }

    public BohJournalEntity() {
    }

    public BohJournalEntity(int bohId, int journalId) {
        this.bohId = bohId;
        this.journalId = journalId;
    }
}
