package am.bibliographic.service;

import am.bibliographic.dao.Operator;
import am.bibliographic.entity.OperatorEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OperatorService extends BaseService {
    private Logger log = Logger.getLogger(OperatorService.class);
    private Operator operator;

    @Autowired
    private OperatorService(Operator operator){
        this.operator = operator;
    }

    public int add(OperatorEntity entity){
        try{
            return operator.create(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public OperatorEntity get(int id){
        try{
            return operator.read(id);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public List<OperatorEntity> getAll(){
        try{
            return operator.getAll();
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
    public void update(OperatorEntity entity){
        try{
            operator.update(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public void remove(OperatorEntity entity){
        try{
            operator.remove(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
}
