package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.entity.PersonEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PersonImplTest extends BaseIntegrationTest {

    private PersonEntity personEntity;

    @Before
    public void setUp(){
        personEntity = createPersona("", true);
    }

    @After
    public void tearDown(){
        try{
            doAutoDelete();
        } catch (Exception e){
            fail("Entity removal failed. Detail: "+e.getMessage());
        }
    }

    @Test
    public void create_sucess(){
        personEntity = personImpl.read(personEntity.getId());
        assertEquals("Person initial Armenian name is incorrect", personNameInitialArm, personEntity.getNameInitialArm());
        assertEquals("Person initial Russian name is incorrect", personNameInitialRus, personEntity.getNameInitialRus());
        assertEquals("Person initial English name is incorrect", personNameInitialEng, personEntity.getNameInitialEng());
        assertEquals("Person final Armenian name is incorrect", personNameFinalArm, personEntity.getNameFinalArm());
        assertEquals("Person final Russian name is incorrect", personNameFinalRus, personEntity.getNameFinalRus());
        assertEquals("Person final English name is incorrect", personNameFinalEng, personEntity.getNameFinalEng());
        assertTrue("Person review state is incorrect", personEntity.isInReviewState());
    }

    @Test
    public void get_success(){
        PersonEntity returnedObject = personImpl.read(personEntity.getId());
        assertTrue("Person retrieval is incorrect", personEntity.equals(returnedObject));
    }

    @Test
    public void update_success(){
        personEntity.setNameInitialArm(personNameInitialArm+" other")
                .setNameInitialRus(personNameInitialRus+" other")
                .setNameInitialEng(personNameInitialEng+" other")
                .setNameFinalArm(personNameFinalArm+" other")
                .setNameFinalRus(personNameFinalRus+" other")
                .setNameFinalEng(personNameFinalEng+" other")
                .setInReviewState(false);
        personImpl.update(personEntity);
        PersonEntity returnedObject = personImpl.read(personEntity.getId());
        assertTrue("Person edit is not correct", personEntity.equals(returnedObject));
    }

    @Test
    public void getAll_success(){
        PersonEntity otherPerson = createPersona(" other", false);
        assertEquals("All persons retrieval is incorrect", 2, personImpl.getAll().size());
    }
}
