package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.entity.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DuplicateKeyException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StatisticsImplTest extends BaseIntegrationTest {

    private JournalEntity journal;
    private OperatorEntity operator;
    private PersonEntity person;
    private ScienceFieldEntity scienceField;
    private StatisticsEntity statistics;

    @Before
    public void setUp(){
        operator = createOperator("Karen", true);
        person = createPersona("", true);
        scienceField = createScienceField("");
        journal = createJournal("ARM-111", "", false, 0, operator, person, scienceField);
        statistics = createStatistics(journal.getId(), 0);

    }

    @After
    public void tearDown(){
        doAutoDelete();
    }

    @Test
    public void createAndGet_success(){
        StatisticsEntity otherStat = statisticsImpl.read(statistics.getId());
        assertEquals("Statistics entity is not created", statistics.getId(), otherStat.getId());
        assertEquals("Statistics IF2010 field is not set", 100, otherStat.getIF2010());
        assertEquals("Statistics IF2011 field is not set", 101, otherStat.getIF2011());
        assertEquals("Statistics IF2012 field is not set", 102, otherStat.getIF2012());
        assertEquals("Statistics IF2013 field is not set", 103, otherStat.getIF2013());
        assertEquals("Statistics IF2014 field is not set", 104, otherStat.getIF2014());
        assertEquals("Statistics IF2015 field is not set", 105, otherStat.getIF2015());
        assertEquals("Statistics IF2016 field is not set", 106, otherStat.getIF2016());
        assertEquals("Statistics IF2017 field is not set", 107, otherStat.getIF2017());
        assertEquals("Statistics IF2018 field is not set", 108, otherStat.getIF2018());
        assertEquals("Statistics IF2019 field is not set", 109, otherStat.getIF2019());
        assertEquals("Statistics IF2020 field is not set", 110, otherStat.getIF2020());

        assertEquals("Statistics nIssueElib field is not set", 1, otherStat.getnIssueElib());
        assertEquals("Statistics nIssueAINC field is not set", 2, otherStat.getnIssueAINC());
        assertEquals("Statistics nArticleElib field is not set", 3, otherStat.getnArticleElib());
        assertEquals("Statistics nArticleAINC field is not set", 4, otherStat.getnArticleAINC());
        assertEquals("Statistics nReferenceAINC field is not set", 5, otherStat.getnReferenceAINC());
        assertEquals("Statistics nCitationAINC field is not set", 6, otherStat.getnCitationAINC());
        assertEquals("Statistics nSelfciteAINC field is not set", 7, otherStat.getnSelfciteAINC());
    }

    @Test(expected = DuplicateKeyException.class)
    public void createWithSameCode_fail(){
        statistics = createStatistics(journal.getId(), 0);
    }

    @Test
    public void getAll_success(){
        JournalEntity otherJournal = createJournal("ARM-999", "", false, 0, operator, person, scienceField);
        StatisticsEntity otherStatistics = createStatistics(otherJournal.getId(),0);
        assertEquals("Statistics objects are not fully retrieved", 2, statisticsImpl.getAll().size());
    }

    @Test
    public void update_success(){
        statistics
                .setIF2010(0)
                .setIF2011(0)
                .setIF2012(0)
                .setIF2013(0)
                .setIF2014(0)
                .setIF2015(0)
                .setIF2016(0)
                .setIF2017(0)
                .setIF2018(0)
                .setIF2019(0)
                .setIF2020(0)
                .setnIssueElib(0)
                .setnIssueAINC(0)
                .setnArticleElib(0)
                .setnArticleAINC(0)
                .setnReferenceAINC(0)
                .setnCitationAINC(0)
                .setnSelfciteAINC(0);
        statisticsImpl.update(statistics);
        statistics = statisticsImpl.read(statistics.getId());
        assertEquals("Statistics IF2010 field is not updated", 0, statistics.getIF2010());
        assertEquals("Statistics IF2011 field is not updated", 0, statistics.getIF2011());
        assertEquals("Statistics IF2012 field is not updated", 0, statistics.getIF2012());
        assertEquals("Statistics IF2013 field is not updated", 0, statistics.getIF2013());
        assertEquals("Statistics IF2014 field is not updated", 0, statistics.getIF2014());
        assertEquals("Statistics IF2015 field is not updated", 0, statistics.getIF2015());
        assertEquals("Statistics IF2016 field is not updated", 0, statistics.getIF2016());
        assertEquals("Statistics IF2017 field is not updated", 0, statistics.getIF2017());
        assertEquals("Statistics IF2018 field is not updated", 0, statistics.getIF2018());
        assertEquals("Statistics IF2019 field is not updated", 0, statistics.getIF2019());
        assertEquals("Statistics IF2020 field is not updated", 0, statistics.getIF2020());

        assertEquals("Statistics nIssueElib field is not set", 0, statistics.getnIssueElib());
        assertEquals("Statistics nIssueAINC field is not set", 0, statistics.getnIssueAINC());
        assertEquals("Statistics nArticleElib field is not set", 0, statistics.getnArticleElib());
        assertEquals("Statistics nArticleAINC field is not set", 0, statistics.getnArticleAINC());
        assertEquals("Statistics nReferenceAINC field is not set", 0, statistics.getnReferenceAINC());
        assertEquals("Statistics nCitationAINC field is not set", 0, statistics.getnCitationAINC());
        assertEquals("Statistics nSelfciteAINC field is not set", 0, statistics.getnSelfciteAINC());
    }
}
