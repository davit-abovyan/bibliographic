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
    public String getById(@PathVariable int ID){
        return gson.toJson(bohService.get(ID));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String getAll(){
        return gson.toJson(bohService.getAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/journal/{ID}")
    public String getAllByJournal(HttpSession session, @PathVariable int ID){
        return gson.toJson(bohJournalService.getAllByJournal(ID));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String add(HttpSession session, @RequestBody String json){
        BOHEntity object = gson.fromJson(json, BOHEntity.class);
        bohService.add(object);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public String edit(HttpSession session, @RequestBody String json){
        BOHEntity object = gson.fromJson(json, BOHEntity.class);
        bohService.update(object);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/journal/")
    public void updateBOHs(@RequestBody String json){
        bohJournalService.updateByJournal(gson.fromJson(json, BohJournalEntity[].class));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public void remove(HttpSession session, @PathVariable int ID){
        bohService.remove(ID);
    }
}
