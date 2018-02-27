package am.bibliographic.dao;

import am.bibliographic.BaseIntegrationTest;
import am.bibliographic.constants.Country;
import am.bibliographic.entity.JournalEntity;
import am.bibliographic.entity.OperatorEntity;
import am.bibliographic.entity.PersonEntity;
import am.bibliographic.entity.ScienceFieldEntity;
import am.bibliographic.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JournalImplTest extends BaseIntegrationTest {

    private JournalEntity journal;
    private OperatorEntity operator;
    private PersonEntity person;
    private ScienceFieldEntity scienceField;

    private String code = "ARM-111";
    private String nameArm = "Astrophysics Arm";
    private String nameRus = "Astrophysics Rus";
    private String nameEng = "Astrophysics Eng";
    private String fullNameArm = "Full name arm";
    private String fullNameRus = "Full name rus";
    private String fullNameEng = "Chemical Journal of Armenia (1995-2017)\n" +
            "Armenian Chemical Journal = Hajkakan Kimiakan Amsagir (1966-1994)\n" +
            "Proceedings of the Academy of Sciences of ArmSSR = HSSR GA Texekagir: Kimiakan gitutyunner (1957-1965)";
    private String ISSNPrint = "0571-1712";
    private String ISBN = "978-99941-944-8-4";
    private String founderArm = "Founder arm";
    private String publisherArm = "Publisher arm";
    private String publisherRus = "Publisher rus";
    private String publisherEng = "Armenian Academy of Sciences";
    private String phone = "(+3741) 23-03-80, 23-20-17";
    private String fax = "(+374 1) 23-24-41";
    private String email = "something@gmail.com";
    private String website = "www.springer.com/astronomy/journal/10511";
    private Country country = Country.ARM;
    private String city = "Yerevan";
    private String address = "Some address";
    private int frequency = 12;
    private int language = 0b101;
    private String journalCategory = "specialized";
    private boolean reviewed = false;
    private boolean inProgress = true;
    private String startYear = "1944";
    private String descriptionArm = "Some long text in Armenian";
    private String descriptionRus = "Some long text in Russian";
    private String descriptionEng = "Some long text in English";
    private String cover = "\\dir\\image\\cover\\";
    private boolean type = false;
    private int indexedLibraries = 20;

    @Before
    public void setUp(){
        operator = createOperator("Karen", true);
        person = createPersona("", true);
        scienceField = createScienceField("");
        journal = createJournal("ARM-111", "", false, 0, operator, person, scienceField);
    }

    @After
    public void tearDown(){
        try{
            doAutoDelete();
        } catch (Exception e){
            fail("Entity removal. Detail: "+e.getMessage());
        }
    }

    @Test
    public void create_success(){
        assertTrue("Science field is not created", journal.getId() > 0);
    }

    @Test
    public void get_success(){
        JournalEntity other = journalImpl.read(journal.getId());
        assertEquals("Journal field code is not set correctly.", code, other.getCode());
        assertEquals("Journal field nameArm is not set correctly.", nameArm, other.getNameArm());
        assertEquals("Journal field nameRus is not set correctly.", nameRus, other.getNameRus());
        assertEquals("Journal field nameEng is not set correctly.", nameEng, other.getNameEng());
        assertEquals("Journal field fullNameArm is not set correctly.", fullNameArm, other.getFullNameArm());
        assertEquals("Journal field fullNameRus is not set correctly.", fullNameRus, other.getFullNameRus());
        assertEquals("Journal field fullNameEng is not set correctly.", fullNameEng, other.getFullNameEng());
        assertEquals("Journal field ISSNPrint is not set correctly.", ISSNPrint, other.getISSNPrint());
        assertEquals("Journal field ISBN is not set correctly.", ISBN, other.getISBN());
        assertEquals("Journal field founderArm is not set correctly.", founderArm, other.getFounderArm());
        assertEquals("Journal field publisherArm is not set correctly.", publisherArm, other.getPublisherArm());
        assertEquals("Journal field publisherRus is not set correctly.", publisherRus, other.getPublisherRus());
        assertEquals("Journal field publisherEng is not set correctly.", publisherEng, other.getPublisherEng());
        assertEquals("Journal field phone is not set correctly.", phone, other.getPhone());
        assertEquals("Journal field fax is not set correctly.", fax, other.getFax());
        assertEquals("Journal field email is not set correctly.", email, other.getEmail());
        assertEquals("Journal field website is not set correctly.", website, other.getWebsite());
        assertEquals("Journal field country is not set correctly.", country, other.getCountry());
        assertEquals("Journal field city is not set correctly.", city, other.getCity());
        assertEquals("Journal field address is not set correctly.", address, other.getAddress());
        assertEquals("Journal field frequency is not set correctly.", frequency, other.getFrequency());
        assertEquals("Journal field language is not set correctly.", language, other.getLanguage());
        assertEquals("Journal field journalCategory is not set correctly.", journalCategory, other.getJournalCategory());
        assertEquals("Journal field reviewed is not set correctly.", reviewed, other.isReviewed());
        assertEquals("Journal field inProgress is not set correctly.", inProgress, other.isInProgress());
        assertEquals("Journal field startYear is not set correctly.", startYear, other.getStartYear());
        assertEquals("Journal field descriptionArm is not set correctly.", descriptionArm, other.getDescriptionArm());
        assertEquals("Journal field descriptionRus is not set correctly.", descriptionRus, other.getDescriptionRus());
        assertEquals("Journal field descriptionEng is not set correctly.", descriptionEng, other.getDescriptionEng());
        assertEquals("Journal field cover is not set correctly.", cover, other.getCover());
        assertEquals("Journal field type is not set correctly.", type, other.isType());
        assertEquals("Journal field indexedLibraries is not set correctly.", indexedLibraries, other.getIndexedLibraries());
        assertEquals("Journal field OperatorId is not set correctly.", operator.getId(), other.getOperatorId());
        assertEquals("Journal field ReviewerId is not set correctly.", person.getId(), other.getEditor());
        assertEquals("Journal field science Field id is not set correctly.", scienceField.getId(), other.getScienceFieldId());
    }

    @Test
    public void update_success(){
        String addition = " something added";
        String code = "ARM-999";
        String nameArm = "Astrophysics Arm"+addition;
        String nameRus = "Astrophysics Rus"+addition;
        String nameEng = "Astrophysics Eng"+addition;
        String fullNameArm = "Full name arm"+addition;
        String fullNameRus = "Full name rus"+addition;
        String fullNameEng = "Chemical Journal of Armenia (1995-2017)\n" +
        "Armenian Chemical Journal = Hajkakan Kimiakan Amsagir (1966-1994)\n" +
        "Proceedings of the Academy of Sciences of ArmSSR = HSSR GA Texekagir: Kimiakan gitutyunner (1957-1965)"+addition;
        String ISSNPrint = "0000-9999";
        String ISBN = "978-99941-944-8-4"+addition;
        String founderArm = "Founder arm"+addition;
        String publisherArm = "Publisher arm"+addition;
        String publisherRus = "Publisher rus"+addition;
        String publisherEng = "Armenian Academy of Sciences"+addition;
        String phone = "(+3741) 23-03-80, 23-20-17"+addition;
        String fax = "(+374 1) 23-24-41"+addition;
        String email = "something@gmail.com+addition";
        String website = "www.springer.com/astronomy/journal/10511"+addition;
        Country country = Country.ARM;
        String city = "Yerevan"+addition;
        String address = "Some address"+addition;
        int frequency = 20;
        int language = 0b001;
        String journalCategory = "specialized"+addition;
        String startYear = "2000";
        String descriptionArm = "Some long text in Armenian"+addition;
        String descriptionRus = "Some long text in Russian"+addition;
        String descriptionEng = "Some long text in English"+addition;
        String cover = "\\dir\\image\\cover\\"+addition;
        int indexedLibraries = 28;

        journal
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
            .setCountry(country.name())
            .setCity(city)
            .setAddress(address)
            .setFrequency(frequency)
            .setLanguage(language)
            .setJournalCategory(journalCategory)
            .setReviewed(true)
            .setInProgress(false)
            .setStartYear(startYear)
            .setDescriptionArm(descriptionArm)
            .setDescriptionRus(descriptionRus)
            .setDescriptionEng(descriptionEng)
            .setCover(cover)
            .setType(true)
            .setIndexedLibraries(indexedLibraries)
            .setOperatorId(operator.getId())
            .setEditor(person.getId())
            .setScienceFieldId(scienceField.getId());
        journalImpl.update(journal);

        JournalEntity other = journalImpl.read(journal.getId());
        assertEquals("Journal field code is not set correctly.", code, other.getCode());
        assertEquals("Journal field nameArm is not set correctly.", nameArm, other.getNameArm());
        assertEquals("Journal field nameRus is not set correctly.", nameRus, other.getNameRus());
        assertEquals("Journal field nameEng is not set correctly.", nameEng, other.getNameEng());
        assertEquals("Journal field fullNameArm is not set correctly.", fullNameArm, other.getFullNameArm());
        assertEquals("Journal field fullNameRus is not set correctly.", fullNameRus, other.getFullNameRus());
        assertEquals("Journal field fullNameEng is not set correctly.", fullNameEng, other.getFullNameEng());
        assertEquals("Journal field ISSNPrint is not set correctly.", ISSNPrint, other.getISSNPrint());
        assertEquals("Journal field ISBN is not set correctly.", ISBN, other.getISBN());
        assertEquals("Journal field founderArm is not set correctly.", founderArm, other.getFounderArm());
        assertEquals("Journal field publisherArm is not set correctly.", publisherArm, other.getPublisherArm());
        assertEquals("Journal field publisherRus is not set correctly.", publisherRus, other.getPublisherRus());
        assertEquals("Journal field publisherEng is not set correctly.", publisherEng, other.getPublisherEng());
        assertEquals("Journal field phone is not set correctly.", phone, other.getPhone());
        assertEquals("Journal field fax is not set correctly.", fax, other.getFax());
        assertEquals("Journal field email is not set correctly.", email, other.getEmail());
        assertEquals("Journal field website is not set correctly.", website, other.getWebsite());
        assertEquals("Journal field country is not set correctly.", country, other.getCountry());
        assertEquals("Journal field city is not set correctly.", city, other.getCity());
        assertEquals("Journal field address is not set correctly.", address, other.getAddress());
        assertEquals("Journal field frequency is not set correctly.", frequency, other.getFrequency());
        assertEquals("Journal field language is not set correctly.", language, other.getLanguage());
        assertEquals("Journal field journalCategory is not set correctly.", journalCategory, other.getJournalCategory());
        assertTrue("Journal field reviewed is not set correctly.", other.isReviewed());
        assertFalse("Journal field inProgress is not set correctly.", other.isInProgress());
        assertEquals("Journal field startYear is not set correctly.", startYear, other.getStartYear());
        assertEquals("Journal field descriptionArm is not set correctly.", descriptionArm, other.getDescriptionArm());
        assertEquals("Journal field descriptionRus is not set correctly.", descriptionRus, other.getDescriptionRus());
        assertEquals("Journal field descriptionEng is not set correctly.", descriptionEng, other.getDescriptionEng());
        assertEquals("Journal field cover is not set correctly.", cover, other.getCover());
        assertTrue("Journal field type is not set correctly.", other.isType());
        assertEquals("Journal field indexedLibraries is not set correctly.", indexedLibraries, other.getIndexedLibraries());
        assertEquals("Journal field OperatorId is not set correctly.", operator.getId(), other.getOperatorId());
        assertEquals("Journal field ReviewerId is not set correctly.", person.getId(), other.getEditor());
        assertEquals("Journal field science Field id is not set correctly.", scienceField.getId(), other.getScienceFieldId());
    }

    @Test
    public void getAll_success(){
        JournalEntity another = createJournal("ARM-999", " something added", true, 8, operator, person, scienceField);
        assertEquals("All science fields are not fully retrieved", 2, journalImpl.getAll().size());
    }
}
