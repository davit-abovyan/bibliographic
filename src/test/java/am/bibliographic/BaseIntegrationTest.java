package am.bibliographic;

import am.bibliographic.constants.Country;
import am.bibliographic.dao.BOH;
import am.bibliographic.dao.BaseDAO;
import am.bibliographic.dao.impl.*;
import am.bibliographic.entity.*;
import am.bibliographic.util.Pair;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Stack;

/**
 * Base class for all integration tests
 */
@Ignore
public class BaseIntegrationTest extends BaseTest {
    protected Stack<Pair<BaseDAO, Entity>> autoDelete = new Stack<>();

    @Autowired
    protected JournalImpl journalImpl;
    @Autowired
    protected OperatorImpl operatorImpl;
    @Autowired
    protected PersonImpl personImpl;
    @Autowired
    protected ScienceFieldImpl scienceFieldImpl;
    @Autowired
    protected StatisticsImpl statisticsImpl;
    @Autowired
    protected BOH BOHImpl;
    @Autowired
    protected BohJournalImpl bohJournal;

    protected String personNameInitialArm = "D. Abovyan arm";
    protected String personNameInitialRus = "D. Abovyan rus";
    protected String personNameInitialEng = "D. Abovyan eng";
    protected String personNameFinalArm = "Davit Levoni Abovyan arm";
    protected String personNameFinalRus = "Davit Levoni Abovyan rus";
    protected String personNameFinalEng = "Davit Levoni Abovyan eng";

    protected JournalEntity createJournal(String code, String addition, boolean state, int number,
                                          OperatorEntity operator, PersonEntity person,
                                          ScienceFieldEntity scienceField) {

        String nameArm = "Astrophysics Arm" + addition;
        String nameRus = "Astrophysics Rus" + addition;
        String nameEng = "Astrophysics Eng" + addition;
        String fullNameArm = "Full name arm" + addition;
        String fullNameRus = "Full name rus" + addition;
        String fullNameEng = "Chemical Journal of Armenia (1995-2017)\n" +
        "Armenian Chemical Journal = Hajkakan Kimiakan Amsagir (1966-1994)\n" +
        "Proceedings of the Academy of Sciences of ArmSSR = HSSR GA Texekagir: Kimiakan gitutyunner (1957-1965)" + addition;
        String ISSNPrint = "0571-1712";
        String ISBN = "978-99941-944-8-4" + addition;
        String founderArm = "Founder arm" + addition;
        String publisherArm = "Publisher arm" + addition;
        String publisherRus = "Publisher rus" + addition;
        String publisherEng = "Armenian Academy of Sciences" + addition;
        String phone = "(+3741) 23-03-80, 23-20-17" + addition;
        String fax = "(+374 1) 23-24-41" + addition;
        String email = "something@gmail.com" + addition;
        String website = "www.springer.com/astronomy/journal/10511" + addition;
        Country country = Country.ARM;
        String city = "Yerevan" + addition;
        String address = "Some address" + addition;
        int frequency = 12 + number;
        int language = 0b101;
        String journalCategory = "specialized" + addition;
        boolean reviewed = state;
        boolean inProgress = !state;
        String startYear = "1944";
        String descriptionArm = "Some long text in Armenian" + addition;
        String descriptionRus = "Some long text in Russian" + addition;
        String descriptionEng = "Some long text in English" + addition;
        String cover = "\\dir\\image\\cover\\" + addition;
        boolean type = state;
        int indexedLibraries = 20 + number;

        JournalEntity journalEntity = new JournalEntity()
                .setCode(code)
                .setNameArm(nameArm)
                .setNameRus(nameRus)
                .setNameEng(nameEng)
                .setFullNameArm(fullNameArm)
                .setFullNameRus(fullNameRus)
                .setFullNameEng(fullNameEng)
                .setISSNPrint(ISSNPrint)
                .setISBN(ISBN)
                .setFounderArm(founderArm)
                .setPublisherArm(publisherArm)
                .setPublisherRus(publisherRus)
                .setPublisherEng(publisherEng)
                .setPhone(phone)
                .setFax(fax)
                .setEmail(email)
                .setWebsite(website)
                .setCountry(country)
                .setCity(city)
                .setAddress(address)
                .setFrequency(frequency)
                .setLanguage(language)
                .setJournalCategory(journalCategory)
                .setReviewed(reviewed)
                .setInProgress(inProgress)
                .setStartYear(startYear)
                .setDescriptionArm(descriptionArm)
                .setDescriptionRus(descriptionRus)
                .setDescriptionEng(descriptionEng)
                .setCover(cover)
                .setType(type)
                .setIndexedLibraries(indexedLibraries)
                .setOperatorId(operator.getId())
                .setEditor(person.getId())
                .setScienceFieldId(scienceField.getId());
        journalImpl.create(journalEntity);
        autoDelete.push(new Pair<>(journalImpl, journalEntity));
        return journalEntity;
    }

    protected ScienceFieldEntity createScienceField(String addition){
        String scieceFieldNameArm = "Economics Arm" + addition;
        String scieceFieldNameRus = "Economics Rus" + addition;
        String scieceFieldNameEng = "Economics Eng" + addition;

        ScienceFieldEntity scienceFieldEntity = new ScienceFieldEntity(scieceFieldNameArm, scieceFieldNameRus, scieceFieldNameEng);
        scienceFieldImpl.create(scienceFieldEntity);
        autoDelete.push(new Pair<>(scienceFieldImpl, scienceFieldEntity));
        return scienceFieldEntity;
    }

    protected PersonEntity createPersona(String addition, boolean state){
        PersonEntity personEntity = new PersonEntity()
                .setNameInitialArm(personNameInitialArm + addition)
                .setNameInitialRus(personNameInitialRus + addition)
                .setNameInitialEng(personNameInitialEng + addition)
                .setNameFinalArm(personNameFinalArm + addition)
                .setNameFinalRus(personNameFinalRus + addition)
                .setNameFinalEng(personNameFinalEng + addition)
                .setReviewState(state);
        personImpl.create(personEntity);
        autoDelete.push(new Pair<>(personImpl,personEntity));
        return personEntity;
    }

    protected BOHEntity createBOH(String name){
        BOHEntity bohEntity = new BOHEntity(name);
        BOHImpl.create(bohEntity);
        autoDelete.push(new Pair<>(BOHImpl, bohEntity));
        return bohEntity;
    }

    protected OperatorEntity createOperator(String name, boolean isAdmin){
        OperatorEntity operatorEntity = new OperatorEntity(name, isAdmin);
        operatorImpl.create(operatorEntity);
        autoDelete.push(new Pair<>(operatorImpl, operatorEntity));
        return operatorEntity;
    }

    protected StatisticsEntity createStatistics(int journalId, int start){
        StatisticsEntity statistics = new StatisticsEntity(journalId,start+1,start+2,start+3,
                start+4,start+5,start+6, start+7,start+8,start+9,
                start+10, start+11, start+12, start+13);
        statisticsImpl.create(statistics);
        autoDelete.push(new Pair<>(statisticsImpl, statistics));
        return statistics;
    }

    protected void doAutoDelete(){
        while (!autoDelete.empty()){
            Pair<BaseDAO, Entity> pair = autoDelete.pop();
            if( pair.getSecond() instanceof IdEntity )
                pair.getFirst().remove(pair.getSecond().getId());
            else
                pair.getFirst().remove(pair.getSecond());
        }
    }
}
