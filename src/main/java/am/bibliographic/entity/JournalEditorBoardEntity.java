package am.bibliographic.entity;

public class JournalEditorBoardEntity implements MultyIdEntity{
    private String journalId;
    private int editorId;
    private String editorPositionArm;
    private String editorPositionRus;
    private String editorPositionEng;

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public String getEditorPositionArm() {
        return editorPositionArm;
    }

    public void setEditorPositionArm(String editorPositionArm) {
        this.editorPositionArm = editorPositionArm;
    }

    public String getEditorPositionRus() {
        return editorPositionRus;
    }

    public void setEditorPositionRus(String editorPositionRus) {
        this.editorPositionRus = editorPositionRus;
    }

    public String getEditorPositionEng() {
        return editorPositionEng;
    }

    public void setEditorPositionEng(String editorPositionEng) {
        this.editorPositionEng = editorPositionEng;
    }

    public JournalEditorBoardEntity() {
    }
}
