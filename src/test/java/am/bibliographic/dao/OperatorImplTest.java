package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.entity.OperatorEntity;
import am.bibliographic.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorImplTest extends BaseIntegrationTest {

    private String name = "Karen";
    private OperatorEntity operator;

    @Before
    public void setUp(){
        operator = createOperator(name, true);
    }

    @After
    public void tearDown(){
        try{
            doAutoDelete();
        }catch (Exception e){
            fail("Entity removal failed in Person test. Detail: "+e.getMessage());
        }
    }

    @Test
    public void create_success(){
        assertTrue("Operator is not created", operator.getId() > 0);
    }

    @Test
    public void get_success(){
        assertEquals("Operator is not returned", name, operatorImpl.read(operator.getId()).getName());
    }

    @Test
    public void getAll_success(){
        OperatorEntity otherOperator = new OperatorEntity("Jone",false);
        operatorImpl.create(otherOperator);
        autoDelete.push(new Pair<>(operatorImpl, operator));
        assertEquals("The full list of operators is not returned", 2, operatorImpl.getAll().size());
    }

    @Test
    public void update_success(){
        String newName = "Davit";
        operator.setName(newName);
        operator.setIs_reviewer(false);
        operatorImpl.update(operator);
        OperatorEntity updatedOperator = operatorImpl.read(operator.getId());
        assertEquals("Operator name is not edited", newName, updatedOperator.getName());
        assertFalse("Operator admin status is not edited", updatedOperator.isIs_reviewer());
    }
}
