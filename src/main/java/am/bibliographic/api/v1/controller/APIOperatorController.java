package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.entity.OperatorEntity;
import am.bibliographic.service.OperatorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1.0/operator", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIOperatorController extends APIController {

    private OperatorService operatorService;

    @Autowired
    public void setOperatorService(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public ResponseEntity<String> getById(HttpSession session, @PathVariable int ID){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(operatorService.get(ID)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<String> getAll(HttpSession session){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(operatorService.getAll()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<String> add(HttpSession session,
                                 @RequestParam("name") String name,
                                 @RequestParam(name = "isAdmin", required = false, defaultValue = "false") boolean isAdmin){
        OperatorEntity object = new OperatorEntity(name, isAdmin);
        operatorService.add(object);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{ID}")
    public ResponseEntity<String> edit(HttpSession session,
                                  @PathVariable int ID,
                                  @RequestParam("name") String name,
                                  @RequestParam(name = "isAdmin", required = false, defaultValue = "false") boolean isAdmin){
        OperatorEntity object = new OperatorEntity(name, isAdmin);
        object.setId(ID);
        operatorService.update(object);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public ResponseEntity remove(HttpSession session,
                                    @PathVariable int ID){
        operatorService.remove(ID);
        return new ResponseEntity(HttpStatus.OK);
    }
}
