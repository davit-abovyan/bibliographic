package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.dao.impl.ScienceFieldImpl;
import am.bibliographic.entity.ScienceFieldEntity;
import am.bibliographic.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ScienceFieldImplTest extends BaseIntegrationTest {

    @Autowired
    ScienceFieldImpl scienceFieldImpl;

    private String nameArm = "Economics Arm";
    private String nameRus = "Economics Rus";
    private String nameEng = "Economics Eng";
    private ScienceFieldEntity scienceFieldEntity;

    @Before
    public void setUp(){
        scienceFieldEntity = new ScienceFieldEntity().setNameArm(nameArm).setNameRus(nameRus).setNameEng(nameEng);
        scienceFieldImpl.create(scienceFieldEntity);
        scienceFieldEntity = scienceFieldImpl.read(scienceFieldEntity.getId());
        autoDelete.push(new Pair<>(scienceFieldImpl, scienceFieldEntity));
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
    public void create_success(){
        assertTrue("Science field is not created", scienceFieldEntity.getId() > 0);
    }

    @Test
    public void read_success(){
        assertEquals("Science field Armenian name is not set correctly", nameArm, scienceFieldEntity.getNameArm());
        assertEquals("Science field Russian name is not set correctly", nameRus, scienceFieldEntity.getNameRus());
        assertEquals("Science field English name is not set correctly", nameEng, scienceFieldEntity.getNameEng());
    }

    @Test
    public void update_success(){
        String newNameArm = "New Economics Arm";
        String newNameRus = "New Economics Rus";
        String newNameEng = "New Economics Eng";
        scienceFieldEntity.setNameArm(newNameArm)
                .setNameRus(newNameRus)
                .setNameEng(newNameEng);
        scienceFieldImpl.update(scienceFieldEntity);
        assertEquals("Science field Armenian name is not updated correctly", newNameArm, scienceFieldEntity.getNameArm());
        assertEquals("Science field Russian name is not updated correctly", newNameRus, scienceFieldEntity.getNameRus());
        assertEquals("Science field English name is not updated correctly", newNameEng, scienceFieldEntity.getNameEng());
    }

    @Test
    public void getAll_success(){
        String newNameArm = "New Economics Arm";
        String newNameRus = "New Economics Rus";
        String newNameEng = "New Economics Eng";
        ScienceFieldEntity anotherScienceField = new ScienceFieldEntity()
                .setNameEng(newNameArm)
                .setNameRus(newNameRus)
                .setNameEng(newNameEng);
        scienceFieldImpl.create(anotherScienceField);
        autoDelete.push(new Pair<>(scienceFieldImpl, anotherScienceField));
        assertEquals("All science fields are not fully retrieved", 2, scienceFieldImpl.getAll().size());
    }

}
