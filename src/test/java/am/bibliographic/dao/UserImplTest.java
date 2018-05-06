package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.entity.OperatorEntity;
import am.bibliographic.entity.UserEntity;
import am.bibliographic.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserImplTest extends BaseIntegrationTest {

    private final String userName = "user@user.com";
    private final String password = "P@ssw0rd";
    private UserEntity user;

    @Before
    public void setUp(){
        user = createUser(userName, password, true);
    }

    @After
    public void tearDown(){
        doAutoDelete();
    }

    @Test
    public void create_success(){
        assertEquals("User is not created", userName, user.getUsername());
    }

    @Test
    public void get_success(){
        String returnName = userInfoImpl.read(user.getUsername()).getUsername();
        assertEquals("Operator is not returned", userName, returnName);
    }

    @Test
    public void getAll_success(){
        UserEntity otherUser = new UserEntity().setUsername("Jone").setPassword("aaa").setRole("ROLE_USER");
        userInfoImpl.create(otherUser);
        autoDelete.push(new Pair<>(userInfoImpl, otherUser));
        assertEquals("The full list of users is not returned", 2, userInfoImpl.getAll().size());
    }

    @Test
    public void update_success(){
        String newAuthority = "ROLE_USER";
        String newPass = "1234";
        user.setPassword(newPass);
        user.setRole(newAuthority);
        user.setEnabled(true);
        userInfoImpl.update(user);
        UserEntity updatedUser = userInfoImpl.read(user.getUsername());
        assertEquals("User name is not edited", user, updatedUser);
    }
}
