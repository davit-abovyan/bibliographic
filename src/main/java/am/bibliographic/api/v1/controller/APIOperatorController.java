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
@RequestMapping(value = "/api/v1.0/operator",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class APIOperatorController extends APIController {

    private OperatorService operatorService;

    @Autowired
    public void setOperatorService(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public String getById(HttpSession session, @PathVariable int ID){
        return gson.toJson(operatorService.get(ID));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String getAll(HttpSession session){
        return gson.toJson(operatorService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String add(HttpSession session, @RequestBody String json){
        OperatorEntity object = gson.fromJson(json, OperatorEntity.class);
        operatorService.add(object);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public String edit(HttpSession session, @RequestBody String json){
        OperatorEntity object = gson.fromJson(json, OperatorEntity.class);
        operatorService.update(object);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public void remove(HttpSession session, @PathVariable int ID){
        operatorService.remove(ID);
    }
}
