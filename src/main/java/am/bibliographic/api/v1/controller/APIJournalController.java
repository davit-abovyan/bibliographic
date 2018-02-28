package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.constants.Country;
import am.bibliographic.entity.JournalEntity;
import am.bibliographic.service.JournalService;
import am.bibliographic.service.StatisticsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1.0/journal",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class APIJournalController extends APIController {

    private JournalService journalService;
    private StatisticsService statisticsService;

    @Autowired
    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }

    @Autowired
    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public ResponseEntity<String> getById(HttpSession session, @PathVariable int ID){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(journalService.get(ID)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<String> getAll(HttpSession session){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(journalService.getAll()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<String> add(HttpSession session, @RequestBody String json){
        gson = new Gson();
        JournalEntity object = gson.fromJson(json, JournalEntity.class);
        journalService.add(object);
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public ResponseEntity<String> edit(HttpSession session, @RequestBody String json){
        gson = new Gson();
        JournalEntity object = gson.fromJson(json, JournalEntity.class);
        journalService.update(object);
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public ResponseEntity<String> remove(HttpSession session,
                                         @PathVariable int ID){
        journalService.remove(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
