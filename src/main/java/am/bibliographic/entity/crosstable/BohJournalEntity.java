package am.bibliographic.entity.crosstable;

import am.bibliographic.entity.MultyIdEntity;

public class BohJournalEntity implements MultyIdEntity {

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
