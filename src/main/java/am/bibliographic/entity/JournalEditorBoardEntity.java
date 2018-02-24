package am.bibliographic.entity;

public class JournalEditorBoardEntity implements MultyIdEntity {

    private String journalId;
    private int editorId;
    private String editorPositionArm;
    private String editorPositionRus;
    private String editorPositionEng;

    public JournalEditorBoardEntity() {}

    // full constructor
    public JournalEditorBoardEntity(String journalId, int editorId, String editorPositionArm, String editorPositionRus,
                                    String editorPositionEng) {
        this.journalId = journalId;
        this.editorId = editorId;
        this.editorPositionArm = editorPositionArm;
        this.editorPositionRus = editorPositionRus;
        this.editorPositionEng = editorPositionEng;
    }

    public String getJournalId() {
        return journalId;
    }

    public JournalEditorBoardEntity setJournalId(String journalId) {
        this.journalId = journalId;
        return this;
    }

    public int getEditorId() {
        return editorId;
    }

    public JournalEditorBoardEntity setEditorId(int editorId) {
        this.editorId = editorId;
        return this;
    }

    public String getEditorPositionArm() {
        return editorPositionArm;
    }

    public JournalEditorBoardEntity setEditorPositionArm(String editorPositionArm) {
        this.editorPositionArm = editorPositionArm;
        return this;
    }

    public String getEditorPositionRus() {
        return editorPositionRus;
    }

    public JournalEditorBoardEntity setEditorPositionRus(String editorPositionRus) {
        this.editorPositionRus = editorPositionRus;
        return this;
    }

    public String getEditorPositionEng() {
        return editorPositionEng;
    }

    public JournalEditorBoardEntity setEditorPositionEng(String editorPositionEng) {
        this.editorPositionEng = editorPositionEng;
        return this;
    }

}
