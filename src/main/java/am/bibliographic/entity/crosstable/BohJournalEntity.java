package am.bibliographic.entity.crosstable;

import am.bibliographic.entity.NoIdEntity;

public class BohJournalEntity implements NoIdEntity {

    private int journalId;
    private int bohId;

    public BohJournalEntity() {}

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
