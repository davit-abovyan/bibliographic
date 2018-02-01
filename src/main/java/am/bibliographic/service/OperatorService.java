package am.bibliographic.service;

import am.bibliographic.dao.Operator;
import am.bibliographic.entity.OperatorEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService extends BaseService {

    private Operator operator;

    @Autowired
    private OperatorService(Operator operator){
        this.operator = operator;
    }

    public int add(OperatorEntity entity){
        return operator.create(entity);
    }

    public OperatorEntity get(int id){
        OperatorEntity entity = operator.read(id);
        return  entity;
    }

    public List<OperatorEntity> getAll(){
        return operator.getAll();
    }

    public void update(OperatorEntity entity){
        operator.update(entity);
    }

    public void remove(int id){
        operator.remove(id);
    }
}
