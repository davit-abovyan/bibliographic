package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.constants.Country;
import am.bibliographic.dao.impl.*;
import am.bibliographic.entity.*;
import am.bibliographic.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
        try{
            doAutoDelete();
        } catch (Exception e){
            fail("Entity removal failed in Person test. Detail: "+e.getMessage());
        }
    }

    @Test
    public void createAndGet_success(){
        assertEquals("Statistics entity is not created", statistics.getJournalId(),
                statisticsImpl.read(statistics.getJournalId()).getJournalId());
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
                .setIF_2010(0)
                .setIF_2011(0)
                .setIF_2012(0)
                .setIF_2013(0)
                .setIF_2014(0)
                .setIF_2015(0)
                .setnIssueElib(0)
                .setnIssueAINC(0)
                .setnArticleElib(0)
                .setnArticleAINC(0)
                .setnReferenceAINC(0)
                .setnCitationAINC(0)
                .setnSelfciteAINC(0);
        statisticsImpl.update(statistics);
        statistics = statisticsImpl.read(statistics.getJournalId());
        assertEquals("Statistics IF_2010 field is not updated", 0, statistics.getIF_2010());
        assertEquals("Statistics IF_2011 field is not updated", 0, statistics.getIF_2011());
        assertEquals("Statistics IF_2012 field is not updated", 0, statistics.getIF_2012());
        assertEquals("Statistics IF_2013 field is not updated", 0, statistics.getIF_2013());
        assertEquals("Statistics IF_2014 field is not updated", 0, statistics.getIF_2014());
        assertEquals("Statistics IF_2015 field is not updated", 0, statistics.getIF_2015());


    }
}
