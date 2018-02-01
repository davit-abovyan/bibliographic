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

    private ScienceField scienceField;

    @Autowired
    private ScienceFieldService(ScienceField scienceField){
        this.scienceField = scienceField;
    }

    public int add(ScienceFieldEntity entity){
        return scienceField.create(entity);
    }

    public ScienceFieldEntity get(int id){
        return scienceField.read(id);
    }

    public List<ScienceFieldEntity> getAll(){
        return scienceField.getAll();
    }

    public void update(ScienceFieldEntity entity){
        scienceField.update(entity);
    }

    public void remove(int id){
        scienceField.remove(id);
    }
}
