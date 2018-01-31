package am.bibliographic.service;


import am.bibliographic.dao.ScienceField;
import am.bibliographic.entity.ScienceFieldEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScienceFieldService extends BaseService {
    private Logger log = Logger.getLogger(ScienceFieldService.class);
    private ScienceField scienceField;

    @Autowired
    private ScienceFieldService(ScienceField scienceField){
        this.scienceField = scienceField;
    }

    public int add(ScienceFieldEntity entity){
        try{
            return scienceField.create(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public ScienceFieldEntity get(int id){
        try{
            return scienceField.read(id);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public List<ScienceFieldEntity> getAll(){
        try{
            return scienceField.getAll();
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
    public void update(ScienceFieldEntity entity){
        try{
            scienceField.update(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public void remove(ScienceFieldEntity entity){
        scienceField.remove(entity);
    }
}
