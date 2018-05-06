package am.bibliographic.service;

import am.bibliographic.dao.UserInfo;
import am.bibliographic.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService {

    private UserInfo user;

    @Autowired
    private UserService(UserInfo user){
        this.user = user;
    }

    public boolean add(UserEntity entity){
        return user.create(entity);
    }

    public UserEntity get(String userName){
        UserEntity entity = user.read(userName);
        return  entity;
    }

    public List<UserEntity> getAll(){
        return user.getAll();
    }

    public void update(UserEntity entity){
        user.update(entity);
    }

    public void remove(UserEntity entity){
        user.remove(entity);
    }

    public boolean login(String userName, String pass){
        return user.login(userName, pass);
    }
}
