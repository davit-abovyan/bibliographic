package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.entity.BOHEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BOHImplTest extends BaseIntegrationTest {

    private String name = "1997_boh_N4";
    private BOHEntity bohEntity;

    @Before
    public void setUp(){
        bohEntity = createBOH(name);
    }

    @After
    public void tearDown(){
        try{
            doAutoDelete();
        }catch (Exception e){
            fail("Entity removal failed. Detail: "+e.getMessage());
        }
    }

    @Test
    public void create_success(){
        assertTrue("BOH is not created", bohEntity.getId() > 0);
    }

    @Test
    public void get_success(){
        assertEquals("BOH is not returned", name, BOHImpl.read(bohEntity.getId()).getName());
    }

    @Test
    public void update_success(){
        String newName = "Nikolas";
        bohEntity.setName(newName);
        BOHImpl.update(bohEntity);
        assertEquals("BOH is not edited", newName, BOHImpl.read(bohEntity.getId()).getName());
    }

    @Test
    public void getAll_success(){
        BOHEntity anotherBOH = createBOH("Other boh");
        assertEquals("The full list of BOHs not returned", 2,BOHImpl.getAll().size());
    }
}
