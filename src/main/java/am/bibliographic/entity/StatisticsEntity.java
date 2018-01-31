package am.bibliographic.entity;

public class StatisticsEntity implements IdEntity{
    private int journalId;
    private int IF_2010;
    private int IF_2011;
    private int IF_2012;
    private int IF_2013;
    private int IF_2014;
    private int IF_2015;
    private int nIssueElib;
    private int nIssueAINC;
    private int nArticleElib;
    private int nArticleAINC;
    private int nReferenceAINC;
    private int nCitationAINC;
    private int nSelfciteAINC;

    public StatisticsEntity() {
    }

    public StatisticsEntity(int journalId) {
        this.journalId = journalId;
    }

    public StatisticsEntity(int journalId, int IF_2010, int IF_2011, int IF_2012, int IF_2013, int IF_2014, int IF_2015, int nIssueElib,
                            int nIssueAINC, int nArticleElib, int nArticleAINC, int nReferenceAINC, int nCitationAINC,
                            int nSelfciteAINC) {
        this.journalId = journalId;
        this.IF_2010 = IF_2010;
        this.IF_2011 = IF_2011;
        this.IF_2012 = IF_2012;
        this.IF_2013 = IF_2013;
        this.IF_2014 = IF_2014;
        this.IF_2015 = IF_2015;
        this.nIssueElib = nIssueElib;
        this.nIssueAINC = nIssueAINC;
        this.nArticleElib = nArticleElib;
        this.nArticleAINC = nArticleAINC;
        this.nReferenceAINC = nReferenceAINC;
        this.nCitationAINC = nCitationAINC;
        this.nSelfciteAINC = nSelfciteAINC;
    }

    public int getId() {
        return journalId;
    }

    public StatisticsEntity setJournalId(int journalId) {
        this.journalId = journalId;
        return this;
    }

    public int getIF_2010() {
        return IF_2010;
    }

    public StatisticsEntity setIF_2010(int IF_2010) {
        this.IF_2010 = IF_2010;
        return this;
    }

    public int getIF_2011() {
        return IF_2011;
    }

    public StatisticsEntity setIF_2011(int IF_2011) {
        this.IF_2011 = IF_2011;
        return this;
    }

    public int getIF_2012() {
        return IF_2012;
    }

    public StatisticsEntity setIF_2012(int IF_2012) {
        this.IF_2012 = IF_2012;
        return this;
    }

    public int getIF_2013() {
        return IF_2013;
    }

    public StatisticsEntity setIF_2013(int IF_2013) {
        this.IF_2013 = IF_2013;
        return this;
    }

    public int getIF_2014() {
        return IF_2014;
    }

    public StatisticsEntity setIF_2014(int IF_2014) {
        this.IF_2014 = IF_2014;
        return this;
    }

    public int getIF_2015() {
        return IF_2015;
    }

    public StatisticsEntity setIF_2015(int IF_2015) {
        this.IF_2015 = IF_2015;
        return this;
    }

    public int getnIssueElib() {
        return nIssueElib;
    }

    public StatisticsEntity setnIssueElib(int nIssueElib) {
        this.nIssueElib = nIssueElib;
        return this;
    }

    public int getnIssueAINC() {
        return nIssueAINC;
    }

    public StatisticsEntity setnIssueAINC(int nIssueAINC) {
        this.nIssueAINC = nIssueAINC;
        return this;
    }

    public int getnArticleElib() {
        return nArticleElib;
    }

    public StatisticsEntity setnArticleElib(int nArticleElib) {
        this.nArticleElib = nArticleElib;
        return this;
    }

    public int getnArticleAINC() {
        return nArticleAINC;
    }

    public StatisticsEntity setnArticleAINC(int nArticleAINC) {
        this.nArticleAINC = nArticleAINC;
        return this;
    }

    public int getnReferenceAINC() {
        return nReferenceAINC;
    }

    public StatisticsEntity setnReferenceAINC(int nReferenceAINC) {
        this.nReferenceAINC = nReferenceAINC;
        return this;
    }

    public int getnCitationAINC() {
        return nCitationAINC;
    }

    public StatisticsEntity setnCitationAINC(int nCitationAINC) {
        this.nCitationAINC = nCitationAINC;
        return this;
    }

    public int getnSelfciteAINC() {
        return nSelfciteAINC;
    }

    public StatisticsEntity setnSelfciteAINC(int nSelfciteAINC) {
        this.nSelfciteAINC = nSelfciteAINC;
        return this;
    }
}
