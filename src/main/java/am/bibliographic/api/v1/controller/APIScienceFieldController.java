package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.entity.ScienceFieldEntity;
import am.bibliographic.service.ScienceFieldService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1.0/sciencefield",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class APIScienceFieldController extends APIController {

    private ScienceFieldService scienceFieldService;

    @Autowired
    public void setScienceFieldService(ScienceFieldService scienceFieldService) {
        this.scienceFieldService = scienceFieldService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public ResponseEntity<String> getById(HttpSession session, @PathVariable int ID){
        return new ResponseEntity<>(gson.toJson(scienceFieldService.get(ID)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<String> getAll(HttpSession session){
        return new ResponseEntity<>(gson.toJson(scienceFieldService.getAll()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<String> add(HttpSession session, @RequestBody String json){
        ScienceFieldEntity object = gson.fromJson(json, ScienceFieldEntity.class);
        scienceFieldService.add(object);
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public ResponseEntity<String> edit(HttpSession session, @RequestBody String json){
        ScienceFieldEntity object = gson.fromJson(json, ScienceFieldEntity.class);
        scienceFieldService.update(object);
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public ResponseEntity remove(HttpSession session,
                                 @PathVariable int ID){
        scienceFieldService.remove(ID);
        return new ResponseEntity(HttpStatus.OK);
    }
}
