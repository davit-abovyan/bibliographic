package am.bibliographic.service;

import am.bibliographic.dao.Person;
import am.bibliographic.entity.PersonEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends BaseService {
    private Logger log = Logger.getLogger(PersonService.class);
    private Person person;

    @Autowired
    private PersonService(Person person){
        this.person = person;
    }

    public int add(PersonEntity entity){
        try{
            return person.create(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public PersonEntity get(int id){
        try{
            return person.read(id);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public List<PersonEntity> getAll(){
        try{
            return person.getAll();
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
    public void update(PersonEntity entity){
        try{
            person.update(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public void remove(PersonEntity entity){
        try{
            person.remove(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
}
