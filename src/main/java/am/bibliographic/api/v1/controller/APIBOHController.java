package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.entity.BOHEntity;
import am.bibliographic.entity.crosstable.BohJournalEntity;
import am.bibliographic.service.BOHService;
import am.bibliographic.service.BohJournalService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1.0/boh",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class APIBOHController extends APIController {

    private BOHService bohService;
    private BohJournalService bohJournalService;

    @Autowired
    public void setBohService(BOHService bohService) {
        this.bohService = bohService;
    }

    @Autowired
    public void setBohJournalService(BohJournalService bohJournalService) {
        this.bohJournalService = bohJournalService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public ResponseEntity<String> getById(@PathVariable int ID){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(bohService.get(ID)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<String> getAll(){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(bohService.getAll()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/journal/{ID}")
    public ResponseEntity<String> getAllByJournal(HttpSession session, @PathVariable int ID){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(bohJournalService.getAllByJournal(ID)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<String> add(HttpSession session, @RequestBody String json){
        gson = new Gson();
        BOHEntity object = gson.fromJson(json, BOHEntity.class);
        bohService.add(object);
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public ResponseEntity<String> edit(HttpSession session, @RequestBody String json){
        gson = new Gson();
        BOHEntity object = gson.fromJson(json, BOHEntity.class);
        bohService.update(object);
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/journal/")
    public ResponseEntity<String> updateBOHs(@RequestBody String json){
        gson = new Gson();
        bohJournalService.updateByJournal(gson.fromJson(json, BohJournalEntity[].class));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public ResponseEntity<String> remove(HttpSession session, @PathVariable int ID){
        bohService.remove(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
