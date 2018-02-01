package am.bibliographic.service;

import am.bibliographic.dao.BOH;
import am.bibliographic.entity.BOHEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BOHService extends BaseService {

    private BOH boh;

    @Autowired
    private BOHService(BOH boh){
        this.boh = boh;
    }

    public int add(BOHEntity bohEntity){
            return boh.create(bohEntity);
    }

    public BOHEntity get(int id){
            return boh.read(id);
    }

    public List<BOHEntity> getAll(){
        return boh.getAll();
    }
    public void update(BOHEntity bohEntity){
        boh.update(bohEntity);
    }

    public void remove(int id){
        boh.remove(id);
    }
}
