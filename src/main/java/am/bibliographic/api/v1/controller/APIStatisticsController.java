package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.dao.Statistics;
import am.bibliographic.entity.StatisticsEntity;
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
@RequestMapping(value = "/api/v1.0/statistics",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class APIStatisticsController extends APIController {

    private StatisticsService statisticsService;

    @Autowired
    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public String getById(HttpSession session, @PathVariable int ID){
        return gson.toJson(statisticsService.get(ID));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String getAll(HttpSession session){
        return gson.toJson(statisticsService.getAll());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public String edit(HttpSession session, @RequestBody String json){
        StatisticsEntity object = gson.fromJson(json, StatisticsEntity.class);

        StatisticsEntity beforeUpdate = statisticsService.get(object.getId());

        object.setnIssueElib(beforeUpdate.getnIssueElib()+object.getnIssueElib())
                .setnIssueAINC(beforeUpdate.getnIssueAINC()+object.getnIssueAINC())
                .setnArticleElib(beforeUpdate.getnArticleElib()+object.getnArticleElib())
                .setnArticleAINC(beforeUpdate.getnArticleAINC()+object.getnArticleAINC())
                .setnReferenceAINC(beforeUpdate.getnReferenceAINC()+object.getnReferenceAINC())
                .setnCitationAINC(beforeUpdate.getnCitationAINC()+object.getnCitationAINC())
                .setnSelfciteAINC(beforeUpdate.getnSelfciteAINC()+object.getnSelfciteAINC());

        statisticsService.update(object);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public void remove(HttpSession session, @PathVariable int ID){
        statisticsService.remove(ID);
    }
}
