package am.bibliographic.service;

import am.bibliographic.dao.BOH;
import am.bibliographic.entity.BOHEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BOHService extends BaseService {
    private Logger log = Logger.getLogger(BOHService.class);
    private BOH boh;

    @Autowired
    private BOHService(BOH boh){
        this.boh = boh;
    }

    public int add(BOHEntity bohEntity){
        try{
            return boh.create(bohEntity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public BOHEntity get(int id){
        try{
            return boh.read(id);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public List<BOHEntity> getAll(){
        try{
            return boh.getAll();
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
    public void update(BOHEntity bohEntity){
        try{
            boh.update(bohEntity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public void remove(BOHEntity entity){
        try{
            boh.remove(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
}
