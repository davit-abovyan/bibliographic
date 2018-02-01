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
@RequestMapping(value = "/api/v1.0/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIPersonController extends APIController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public ResponseEntity<String> getById(HttpSession session, @PathVariable int ID){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(personService.get(ID)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<String> getAll(HttpSession session){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(personService.getAll()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<String> add(HttpSession session,
                                      @RequestParam("nameInitialArm") String nameInitialArm,
                                      @RequestParam("nameInitialRus") String nameInitialRus,
                                      @RequestParam("nameInitialEng") String nameInitialEng,
                                      @RequestParam(name = "nameFinalArm", required = false) String nameFinalArm,
                                      @RequestParam(name = "nameFinalRus", required = false) String nameFinalRus,
                                      @RequestParam(name = "nameFinalEng", required = false) String nameFinalEng,
                                      @RequestParam("reviewState") boolean reviewState){
        PersonEntity object = new PersonEntity(nameInitialArm, nameInitialRus, nameInitialEng);
        object.setNameFinalArm(nameFinalArm);
        object.setNameFinalRus(nameFinalRus);
        object.setNameFinalEng(nameFinalEng);
        personService.add(object);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{ID}")
    public ResponseEntity<String> edit(HttpSession session,
                                       @PathVariable int ID,
                                       @RequestParam("nameInitialArm") String nameInitialArm,
                                       @RequestParam("nameInitialRus") String nameInitialRus,
                                       @RequestParam("nameInitialEng") String nameInitialEng,
                                       @RequestParam(name = "nameFinalArm", required = false) String nameFinalArm,
                                       @RequestParam(name = "nameFinalRus", required = false) String nameFinalRus,
                                       @RequestParam(name = "nameFinalEng", required = false) String nameFinalEng,
                                       @RequestParam("reviewState") boolean reviewState){
        PersonEntity object = new PersonEntity(nameInitialArm, nameInitialRus, nameInitialEng);
        object.setNameFinalArm(nameFinalArm);
        object.setNameFinalRus(nameFinalRus);
        object.setNameFinalEng(nameFinalEng);
        object.setReviewState(reviewState);
        object.setId(ID);
        personService.update(object);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public ResponseEntity remove(HttpSession session,
                                 @PathVariable int ID){
        personService.remove(ID);
        return new ResponseEntity(HttpStatus.OK);
    }
}
