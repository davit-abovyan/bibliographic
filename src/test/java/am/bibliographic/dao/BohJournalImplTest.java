package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.entity.*;
import am.bibliographic.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BohJournalImplTest extends BaseIntegrationTest {

    private BOHEntity boh;
    private JournalEntity journal;
    private OperatorEntity operator;
    private PersonEntity person;
    private ScienceFieldEntity scienceField;
    private BohJournalEntity bohJournalEntity;

    @Before
    public void setUp(){
        boh = createBOH("something");
        operator = createOperator("Karen", true);
        person = createPersona("", true);
        scienceField = createScienceField("");
        journal = createJournal("ARM-111", "", false, 0, operator, person, scienceField);
        bohJournalEntity = new BohJournalEntity(boh.getId(), journal.getId());
        bohJournal.create(bohJournalEntity);
        autoDelete.push(new Pair<>(bohJournal, bohJournalEntity));
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
    public void createAndGetByBOH_success(){
        assertEquals("BOH+Journal pair is not created or retrieved by BOH id",
                1, bohJournal.getByBoh(boh.getId()).size());
    }

    @Test
    public void createAndGetByJournal_success(){
        assertEquals("BOH+Journal pair is not created or retrieved by journal id",
                1, bohJournal.getByJournal(journal.getId()).size());
    }

    @Test
    public void getByBOHAndJournal(){
        assertTrue("BOH+Journal pair relation is not created or retrieved",
                bohJournal.getByBOHAndJournal(boh.getId(), journal.getId()));
    }

}
