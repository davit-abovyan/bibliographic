package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.entity.PersonEntity;
import am.bibliographic.service.PersonService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1.0/person",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class APIPersonController extends APIController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public String getById(HttpSession session, @PathVariable int ID){
        return gson.toJson(personService.get(ID));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String getAll(HttpSession session){
        return gson.toJson(personService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String add(HttpSession session, @RequestBody String json){
        PersonEntity object = gson.fromJson(json, PersonEntity.class);
        personService.add(object);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void edit(HttpSession session, @RequestBody String json){
        PersonEntity object = gson.fromJson(json, PersonEntity.class);
        personService.update(object);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public void remove(HttpSession session, @PathVariable int ID){
        personService.remove(ID);
    }
}
