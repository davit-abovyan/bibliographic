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

    private Person person;

    @Autowired
    private PersonService(Person person){
        this.person = person;
    }

    public int add(PersonEntity entity){
        return person.create(entity);
    }

    public PersonEntity get(int id){
        return person.read(id);
    }

    public List<PersonEntity> getAll(){
        return person.getAll();
    }
    public void update(PersonEntity entity){
        person.update(entity);
    }

    public void remove(int id){
        person.remove(id);
    }
}
