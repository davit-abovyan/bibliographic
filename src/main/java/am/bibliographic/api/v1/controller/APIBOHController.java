package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.entity.BOHEntity;
import am.bibliographic.service.BOHService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api/v1.0/boh", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIBOHController extends APIController {

    private BOHService bohService;

    @Autowired
    public void setBohService(BOHService bohService) {
        this.bohService = bohService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public ResponseEntity<String> getById(HttpSession session, @PathVariable int ID){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(bohService.get(ID)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<String> getAll(HttpSession session){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(bohService.getAll()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<String> add(HttpSession session,
                                  @RequestParam("name") String name){
        BOHEntity object = new BOHEntity(name);
        bohService.add(object);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{ID}")
    public ResponseEntity<String> edit(HttpSession session,
                                  @PathVariable int ID,
                                 @RequestParam("name") String name){
        BOHEntity object = new BOHEntity(name);
        object.setId(ID);
        bohService.update(object);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public ResponseEntity<String> remove(HttpSession session,
                                     @PathVariable int ID){
        bohService.remove(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}