package am.bibliographic.api.v1.controller;

import am.bibliographic.api.v1.APIController;
import am.bibliographic.constants.Country;
import am.bibliographic.entity.JournalEntity;
import am.bibliographic.entity.StatisticsEntity;
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
@RequestMapping(value = "/api/v1.0/journal", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<String> add(HttpSession session,
                   @RequestParam("code") String code,
                   @RequestParam("operatorId") int operatorId,
                   @RequestParam("nameArm") String nameArm,
                   @RequestParam("nameRus") String nameRus,
                   @RequestParam("nameEng") String nameEng,
                   @RequestParam("fullNameArm") String fullNameArm,
                   @RequestParam("fullNameRus") String fullNameRus,
                   @RequestParam("fullNameEng") String fullNameEng,
                   @RequestParam("ISSNPrint") String ISSNPrint,
                   @RequestParam("founderArm") String founderArm,
                   @RequestParam("scienceFieldId") int scienceFieldId,
                   @RequestParam(name="ISBN", required = false, defaultValue = "") String ISBN,
                   @RequestParam(name="publisherArm", required = false, defaultValue = "") String publisherArm,
                   @RequestParam(name="publisherRus", required = false, defaultValue = "") String publisherRus,
                   @RequestParam(name="publisherEng", required = false, defaultValue = "") String publisherEng,
                   @RequestParam(name="phone", required = false, defaultValue = "") String phone,
                   @RequestParam(name="fax", required = false, defaultValue = "") String fax,
                   @RequestParam(name="email", required = false, defaultValue = "") String email,
                   @RequestParam(name="website", required = false, defaultValue = "") String website,
                   @RequestParam(name="country", required = false, defaultValue = "ARM") String country,
                   @RequestParam(name="city", required = false, defaultValue = "") String city,
                   @RequestParam(name="address", required = false, defaultValue = "") String address,
                   @RequestParam(name="frequency", required = false, defaultValue = "-1") int frequency,
                   @RequestParam(name="language", required = false, defaultValue = "-1") int language,
                   @RequestParam(name="journalCategory", required = false, defaultValue = "") String  journalCategory,
                   @RequestParam(name="reviewed", required = false) boolean reviewed,
                   @RequestParam(name="inProgress", required = false) boolean inProgress,
                   @RequestParam(name="startYear", required = false, defaultValue = "") String startYear,
                   @RequestParam(name="editor", required = false, defaultValue = "-1") int editor,
                   @RequestParam(name="descriptionArm", required = false, defaultValue = "") String descriptionArm,
                   @RequestParam(name="descriptionRus", required = false, defaultValue = "") String descriptionRus,
                   @RequestParam(name="descriptionEng", required = false, defaultValue = "") String descriptionEng,
                   @RequestParam(name="cover", required = false, defaultValue = "") String cover,
                   @RequestParam(name="type", required = false) boolean type,
                   @RequestParam(name="indexedLibraries", required = false, defaultValue = "-1") int indexedLibraries){

        JournalEntity object = new JournalEntity(code, operatorId, nameArm, nameRus, nameEng, fullNameArm,
                fullNameRus, fullNameEng, ISSNPrint, founderArm, editor, scienceFieldId)
                .setReviewed(reviewed)
                .setInProgress(inProgress)
                .setType(type)
                .setCountry(Country.valueOf(country));

        if(!"".equals(ISBN)) object.setISBN(ISBN);
        if(!"".equals(publisherArm)) object.setPublisherArm(publisherArm);
        if(!"".equals(publisherRus)) object.setPublisherArm(publisherRus);
        if(!"".equals(publisherEng)) object.setPublisherArm(publisherEng);
        if(!"".equals(phone)) object.setPhone(phone);
        if(!"".equals(fax)) object.setFax(fax);
        if(!"".equals(email)) object.setEmail(email);
        if(!"".equals(website)) object.setWebsite(website);
        if(!"".equals(city)) object.setCity(city);
        if(!"".equals(address)) object.setAddress(address);
        if(frequency>=0) object.setFrequency(frequency);
        if(language>=0) object.setLanguage(language);
        if(!"".equals(journalCategory)) object.setJournalCategory(journalCategory);
        if(!"".equals(startYear)) object.setStartYear(startYear);
        if(!"".equals(descriptionArm)) object.setDescriptionArm(descriptionArm);
        if(!"".equals(descriptionRus)) object.setDescriptionRus(descriptionRus);
        if(!"".equals(descriptionEng)) object.setDescriptionEng(descriptionEng);
        if(!"".equals(cover)) object.setCover(cover);
        if(indexedLibraries>=0) object.setIndexedLibraries(indexedLibraries);

        journalService.add(object);

        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{ID}")
    public ResponseEntity<String> edit(HttpSession session,
                  @PathVariable int ID,
                  @RequestParam("code") String code,
                  @RequestParam("operatorId") int operatorId,
                  @RequestParam("nameArm") String nameArm,
                  @RequestParam("nameRus") String nameRus,
                  @RequestParam("nameEng") String nameEng,
                  @RequestParam("fullNameArm") String fullNameArm,
                  @RequestParam("fullNameRus") String fullNameRus,
                  @RequestParam("fullNameEng") String fullNameEng,
                  @RequestParam("ISSNPrint") String ISSNPrint,
                  @RequestParam("founderArm") String founderArm,
                  @RequestParam("editor") int editor,
                  @RequestParam("scienceFieldId") int scienceFieldId,
                  @RequestParam(name="ISBN", required = false, defaultValue = "") String ISBN,
                  @RequestParam(name="publisherArm", required = false, defaultValue = "") String publisherArm,
                  @RequestParam(name="publisherRus", required = false, defaultValue = "") String publisherRus,
                  @RequestParam(name="publisherEng", required = false, defaultValue = "") String publisherEng,
                  @RequestParam(name="phone", required = false, defaultValue = "") String phone,
                  @RequestParam(name="fax", required = false, defaultValue = "") String fax,
                  @RequestParam(name="email", required = false, defaultValue = "") String email,
                  @RequestParam(name="website", required = false, defaultValue = "") String website,
                  @RequestParam(name="country", required = false, defaultValue = "ARM") String country,
                  @RequestParam(name="city", required = false, defaultValue = "") String city,
                  @RequestParam(name="address", required = false, defaultValue = "") String address,
                  @RequestParam(name="frequency", required = false, defaultValue = "-1") int frequency,
                  @RequestParam(name="language", required = false, defaultValue = "-1") int language,
                  @RequestParam(name="journalCategory", required = false, defaultValue = "") String  journalCategory,
                  @RequestParam(name="reviewed", required = false) boolean reviewed,
                  @RequestParam(name="inProgress", required = false) boolean inProgress,
                  @RequestParam(name="startYear", required = false, defaultValue = "") String startYear,
                  @RequestParam(name="descriptionArm", required = false, defaultValue = "") String descriptionArm,
                  @RequestParam(name="descriptionRus", required = false, defaultValue = "") String descriptionRus,
                  @RequestParam(name="descriptionEng", required = false, defaultValue = "") String descriptionEng,
                  @RequestParam(name="cover", required = false, defaultValue = "") String cover,
                  @RequestParam(name="type", required = false) boolean type,
                  @RequestParam(name="indexedLibraries", required = false, defaultValue = "-1") int indexedLibraries) {

        JournalEntity object = new JournalEntity(code, operatorId, nameArm, nameRus, nameEng, fullNameArm,
                fullNameRus, fullNameEng, ISSNPrint, founderArm, editor, scienceFieldId)
                .setReviewed(reviewed)
                .setInProgress(inProgress)
                .setType(type)
                .setCountry(Country.valueOf(country))
                .setId(ID);

        if (!"".equals(ISBN)) object.setISBN(ISBN);
        if (!"".equals(publisherArm)) object.setPublisherArm(publisherArm);
        if (!"".equals(publisherRus)) object.setPublisherArm(publisherRus);
        if (!"".equals(publisherEng)) object.setPublisherArm(publisherEng);
        if (!"".equals(phone)) object.setPhone(phone);
        if (!"".equals(fax)) object.setFax(fax);
        if (!"".equals(email)) object.setEmail(email);
        if (!"".equals(website)) object.setWebsite(website);
        if (!"".equals(city)) object.setCity(city);
        if (!"".equals(address)) object.setAddress(address);
        if (frequency >= 0) object.setFrequency(frequency);
        if (language >= 0) object.setLanguage(language);
        if (!"".equals(journalCategory)) object.setJournalCategory(journalCategory);
        if (!"".equals(startYear)) object.setStartYear(startYear);
        if (!"".equals(descriptionArm)) object.setDescriptionArm(descriptionArm);
        if (!"".equals(descriptionRus)) object.setDescriptionRus(descriptionRus);
        if (!"".equals(descriptionEng)) object.setDescriptionEng(descriptionEng);
        if (!"".equals(cover)) object.setCover(cover);
        if (indexedLibraries >= 0) object.setIndexedLibraries(indexedLibraries);

        journalService.update(object);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(object), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{ID}")
    public ResponseEntity<String> remove(HttpSession session,
                                         @PathVariable int ID){
        journalService.remove(ID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
