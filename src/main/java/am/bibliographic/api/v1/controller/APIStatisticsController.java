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
@RequestMapping(value = "/api/v1.0/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIStatisticsController extends APIController {

    private StatisticsService statisticsService;

    @Autowired
    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ID}")
    public ResponseEntity<String> getById(HttpSession session, @PathVariable int ID){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(statisticsService.get(ID)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<String> getAll(HttpSession session){
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(statisticsService.getAll()), HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/")
//    public ResponseEntity<String> add(HttpSession session,
//                                      @RequestParam(name="journalId") int journalId,
//                                      @RequestParam(name="IF2010", required = false, defaultValue = "-1") int IF2010,
//                                      @RequestParam(name="IF2011", required = false, defaultValue = "-1") int IF2011,
//                                      @RequestParam(name="IF2012", required = false, defaultValue = "-1") int IF2012,
//                                      @RequestParam(name="IF2013", required = false, defaultValue = "-1") int IF2013,
//                                      @RequestParam(name="IF2014", required = false, defaultValue = "-1") int IF2014,
//                                      @RequestParam(name="IF2015", required = false, defaultValue = "-1") int IF2015,
//                                      @RequestParam(name="IF2016", required = false, defaultValue = "-1") int IF2016,
//                                      @RequestParam(name="IF2017", required = false, defaultValue = "-1") int IF2017,
//                                      @RequestParam(name="IF2018", required = false, defaultValue = "-1") int IF2018,
//                                      @RequestParam(name="IF2019", required = false, defaultValue = "-1") int IF2019,
//                                      @RequestParam(name="IF2020", required = false, defaultValue = "-1") int IF2020,
//                                      @RequestParam(name="nIssueElib", required = false, defaultValue = "0") int nIssueElib,
//                                      @RequestParam(name="nIssueAINC", required = false, defaultValue = "0") int nIssueAINC,
//                                      @RequestParam(name="nArticleElib", required = false, defaultValue = "0") int nArticleElib,
//                                      @RequestParam(name="nArticleAINC", required = false, defaultValue = "0") int nArticleAINC,
//                                      @RequestParam(name="nReferenceAINC", required = false, defaultValue = "0") int nReferenceAINC,
//                                      @RequestParam(name="nCitationAINC", required = false, defaultValue = "0") int nCitationAINC,
//                                      @RequestParam(name="nSelfciteAINC", required = false, defaultValue = "0") int nSelfciteAINC){
//        StatisticsEntity object = new StatisticsEntity(journalId)
//                .setnIssueElib(nIssueElib)
//                .setnIssueAINC(nIssueAINC)
//                .setnArticleElib(nArticleElib)
//                .setnArticleAINC(nArticleAINC)
//                .setnReferenceAINC(nReferenceAINC)
//                .setnCitationAINC(nCitationAINC)
//                .setnSelfciteAINC(nSelfciteAINC);
//
//        if(IF2010>=0) object.setIF2010(IF2010);
//        if(IF2011>=0) object.setIF2011(IF2011);
//        if(IF2012>=0) object.setIF2012(IF2012);
//        if(IF2013>=0) object.setIF2013(IF2013);
//        if(IF2014>=0) object.setIF2014(IF2014);
//        if(IF2015>=0) object.setIF2015(IF2015);
//        if(IF2016>=0) object.setIF2016(IF2016);
//        if(IF2017>=0) object.setIF2017(IF2017);
//        if(IF2018>=0) object.setIF2018(IF2018);
//        if(IF2019>=0) object.setIF2019(IF2019);
//        if(IF2020>=0) object.setIF2020(IF2020);
//
//        statisticsService.add(object);
//        Gson gson = new Gson();
//        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{ID}")
    public ResponseEntity<String> edit(HttpSession session,
                                       @PathVariable int ID,
                                       @RequestParam(name="IF2010", required = false, defaultValue = "-1") int IF2010,
                                       @RequestParam(name="IF2011", required = false, defaultValue = "-1") int IF2011,
                                       @RequestParam(name="IF2012", required = false, defaultValue = "-1") int IF2012,
                                       @RequestParam(name="IF2013", required = false, defaultValue = "-1") int IF2013,
                                       @RequestParam(name="IF2014", required = false, defaultValue = "-1") int IF2014,
                                       @RequestParam(name="IF2015", required = false, defaultValue = "-1") int IF2015,
                                       @RequestParam(name="IF2016", required = false, defaultValue = "-1") int IF2016,
                                       @RequestParam(name="IF2017", required = false, defaultValue = "-1") int IF2017,
                                       @RequestParam(name="IF2018", required = false, defaultValue = "-1") int IF2018,
                                       @RequestParam(name="IF2019", required = false, defaultValue = "-1") int IF2019,
                                       @RequestParam(name="IF2020", required = false, defaultValue = "-1") int IF2020,
                                       @RequestParam(name="nIssueElib", required = false) int nIssueElib,
                                       @RequestParam(name="nIssueAINC", required = false) int nIssueAINC,
                                       @RequestParam(name="nArticleElib", required = false) int nArticleElib,
                                       @RequestParam(name="nArticleAINC", required = false) int nArticleAINC,
                                       @RequestParam(name="nReferenceAINC", required = false) int nReferenceAINC,
                                       @RequestParam(name="nCitationAINC", required = false) int nCitationAINC,
                                       @RequestParam(name="nSelfciteAINC", required = false) int nSelfciteAINC){

        StatisticsEntity otherStat = statisticsService.get(ID);

        StatisticsEntity object = new StatisticsEntity(ID)
                .setnIssueElib(otherStat.getnIssueElib()+nIssueElib)
                .setnIssueAINC(otherStat.getnIssueAINC()+nIssueAINC)
                .setnArticleElib(otherStat.getnArticleElib()+nArticleElib)
                .setnArticleAINC(otherStat.getnArticleAINC()+nArticleAINC)
                .setnReferenceAINC(otherStat.getnReferenceAINC()+nReferenceAINC)
                .setnCitationAINC(otherStat.getnCitationAINC()+nCitationAINC)
                .setnSelfciteAINC(otherStat.getnSelfciteAINC()+nSelfciteAINC);

        if(IF2010>=0) object.setIF2010(IF2010);
        if(IF2011>=0) object.setIF2011(IF2011);
        if(IF2012>=0) object.setIF2012(IF2012);
        if(IF2013>=0) object.setIF2013(IF2013);
        if(IF2014>=0) object.setIF2014(IF2014);
        if(IF2015>=0) object.setIF2015(IF2015);
        if(IF2016>=0) object.setIF2016(IF2016);
        if(IF2017>=0) object.setIF2017(IF2017);
        if(IF2018>=0) object.setIF2018(IF2018);
        if(IF2019>=0) object.setIF2019(IF2019);
        if(IF2020>=0) object.setIF2020(IF2020);

        statisticsService.update(object);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public ResponseEntity<String> remove(HttpSession session,
                                         @PathVariable int ID){
        statisticsService.remove(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
