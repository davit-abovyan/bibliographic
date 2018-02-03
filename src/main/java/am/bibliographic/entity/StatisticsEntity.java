package am.bibliographic.entity;

public class StatisticsEntity implements IdEntity{
    private int journalId;
    private int IF2010;
    private int IF2011;
    private int IF2012;
    private int IF2013;
    private int IF2014;
    private int IF2015;
    private int IF2016;
    private int IF2017;
    private int IF2018;
    private int IF2019;
    private int IF2020;
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

    public int getId() {
        return journalId;
    }

    public StatisticsEntity setJournalId(int journalId) {
        this.journalId = journalId;
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

    public int getIF2010() {
        return IF2010;
    }

    public StatisticsEntity setIF2010(int IF2010) {
        this.IF2010 = IF2010;
        return this;
    }

    public int getIF2011() {
        return IF2011;
    }

    public StatisticsEntity setIF2011(int IF2011) {
        this.IF2011 = IF2011;
        return this;
    }

    public int getIF2012() {
        return IF2012;
    }

    public StatisticsEntity setIF2012(int IF2012) {
        this.IF2012 = IF2012;
        return this;
    }

    public int getIF2013() {
        return IF2013;
    }

    public StatisticsEntity setIF2013(int IF2013) {
        this.IF2013 = IF2013;
        return this;
    }

    public int getIF2014() {
        return IF2014;
    }

    public StatisticsEntity setIF2014(int IF2014) {
        this.IF2014 = IF2014;
        return this;
    }

    public int getIF2015() {
        return IF2015;
    }

    public StatisticsEntity setIF2015(int IF2015) {
        this.IF2015 = IF2015;
        return this;
    }

    public int getIF2016() {
        return IF2016;
    }

    public StatisticsEntity setIF2016(int IF2016) {
        this.IF2016 = IF2016;
        return this;
    }

    public int getIF2017() {
        return IF2017;
    }

    public StatisticsEntity setIF2017(int IF2017) {
        this.IF2017 = IF2017;
        return this;
    }

    public int getIF2018() {
        return IF2018;
    }

    public StatisticsEntity setIF2018(int IF2018) {
        this.IF2018 = IF2018;
        return this;
    }

    public int getIF2019() {
        return IF2019;
    }

    public StatisticsEntity setIF2019(int IF2019) {
        this.IF2019 = IF2019;
        return this;
    }

    public int getIF2020() {
        return IF2020;
    }

    public StatisticsEntity setIF2020(int IF2020) {
        this.IF2020 = IF2020;
        return this;
    }
}
