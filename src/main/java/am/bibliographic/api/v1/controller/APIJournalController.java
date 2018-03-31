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
    public String getById(HttpSession session, @PathVariable int ID){
        return gson.toJson(journalService.get(ID));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String getAll(HttpSession session){
        return gson.toJson(journalService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String add(HttpSession session, @RequestBody String json){
        JournalEntity object = gson.fromJson(json, JournalEntity.class);
        journalService.add(object);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public String edit(HttpSession session, @RequestBody String json){
        JournalEntity object = gson.fromJson(json, JournalEntity.class);
        journalService.update(object);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public void remove(HttpSession session, @PathVariable int ID){
        journalService.remove(ID);
    }
}
