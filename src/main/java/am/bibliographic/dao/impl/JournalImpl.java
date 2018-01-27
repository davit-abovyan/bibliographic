package am.bibliographic.dao.impl;

import am.bibliographic.constants.Country;
import am.bibliographic.dao.Journal;
import am.bibliographic.dao.impl.mapper.JournalRowMapper;
import am.bibliographic.entity.Entity;
import am.bibliographic.entity.JournalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
@Component
public class JournalImpl extends NamedParameterJdbcDaoSupport implements Journal {

    @Autowired
    public JournalImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * @see Journal#create(am.bibliographic.entity.JournalEntity)
     */
    @Override
    public int create(JournalEntity entity) {
        // default return value which means nothing added
        int id = -1;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String query = "INSERT INTO journal (code, operator, name_arm, name_rus, name_eng, full_name_arm," +
                " full_name_rus, full_name_eng, ISSN_print, ISBN, founder_arm, publisher_arm, publisher_rus," +
                " publisher_eng, phone, fax, email, website, country, city, address, frequency, language, " +
                " journal_category, reviewed, in_progress, start_year, editor, description_arm, description_rus, " +
                " description_eng, science_field_id, cover, type, indexed_libraries)" +
                " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                " ?, ?, ?, ?)";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getCode());
            ps.setInt(2, entity.getOperatorId());
            ps.setString(3, entity.getNameArm());
            ps.setString(4, entity.getNameRus());
            ps.setString(5, entity.getNameEng());
            ps.setString(6, entity.getFullNameArm());
            ps.setString(7, entity.getFullNameRus());
            ps.setString(8, entity.getFullNameEng());
            ps.setString(9, entity.getISSNPrint());
            ps.setString(10, entity.getISBN());
            ps.setString(11, entity.getFounderArm());
            ps.setString(12, entity.getPublisherArm());
            ps.setString(13, entity.getPublisherRus());
            ps.setString(14, entity.getPublisherEng());
            ps.setString(15, entity.getPhone());
            ps.setString(16, entity.getFax());
            ps.setString(17, entity.getEmail());
            ps.setString(18, entity.getWebsite());
            ps.setString(19, entity.getCountry().name());
            ps.setString(20, entity.getCity());
            ps.setString(21, entity.getAddress());
            ps.setInt(22, entity.getFrequency());
            ps.setInt(23, entity.getLanguage());
            ps.setString(24, entity.getJournalCategory());
            ps.setInt(25, entity.isReviewed() ? 1 : 0);
            ps.setInt(26, entity.isInProgress() ? 1 : 0);
            ps.setString(27, entity.getStartYear());
            ps.setInt(28, entity.getEditor());
            ps.setString(29, entity.getDescriptionArm());
            ps.setString(30, entity.getDescriptionRus());
            ps.setString(31, entity.getDescriptionEng());
            ps.setInt(32, entity.getScienceFieldId());
            ps.setString(33, entity.getCover());
            ps.setInt(34, entity.isType() ? 1 : 0);
            ps.setInt(35, entity.getIndexedLibraries());
            return ps;
        },keyHolder);

        if(result == 1){
            id = keyHolder.getKey().intValue();
            entity.setId(id);
        }
        return id;
    }

    /**
     * @see Journal#read(int)
     */
    @Override
    public JournalEntity read(int id) {
        final String query = "SELECT * FROM journal WHERE id = ? LIMIT 1";
        return getJdbcTemplate().queryForObject(query, new Object[]{id},new JournalRowMapper());
    }

    /**
     * @see Journal#getAll()
     */
    @Override
    public List<JournalEntity> getAll() {
        final String query = "SELECT * FROM journal";
        return getJdbcTemplate().query(query, new JournalRowMapper());
    }

    /**
     * @see Journal#update(am.bibliographic.entity.JournalEntity)
     */
    @Override
    public void update(JournalEntity entity) {
        final String query = "UPDATE journal SET code = ?, operator = ?, name_arm = ?, name_rus = ?, name_eng = ?," +
                " full_name_arm = ?, full_name_rus = ?, full_name_eng = ?, ISSN_print = ?, ISBN = ?, founder_arm = ?, " +
                " publisher_arm = ?, publisher_rus = ?, publisher_eng = ?, phone = ?, fax = ?, email = ?, website = ?, " +
                " country = ?, city = ?, address = ?, frequency = ?, language = ?, journal_category = ?, reviewed = ?, " +
                " in_progress = ?, start_year = ?, editor = ?, description_arm = ?, description_rus = ?, " +
                " description_eng = ?, science_field_id = ?, cover = ?, type = ?, indexed_libraries = ? " +
                " WHERE id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getCode());
            ps.setInt(2, entity.getOperatorId());
            ps.setString(3, entity.getNameArm());
            ps.setString(4, entity.getNameRus());
            ps.setString(5, entity.getNameEng());
            ps.setString(6, entity.getFullNameArm());
            ps.setString(7, entity.getFullNameRus());
            ps.setString(8, entity.getFullNameEng());
            ps.setString(9, entity.getISSNPrint());
            ps.setString(10, entity.getISBN());
            ps.setString(11, entity.getFounderArm());
            ps.setString(12, entity.getPublisherArm());
            ps.setString(13, entity.getPublisherRus());
            ps.setString(14, entity.getPublisherEng());
            ps.setString(15, entity.getPhone());
            ps.setString(16, entity.getFax());
            ps.setString(17, entity.getEmail());
            ps.setString(18, entity.getWebsite());
            ps.setString(19, entity.getCountry().name());
            ps.setString(20, entity.getCity());
            ps.setString(21, entity.getAddress());
            ps.setInt(22, entity.getFrequency());
            ps.setInt(23, entity.getLanguage());
            ps.setString(24, entity.getJournalCategory());
            ps.setInt(25, entity.isReviewed() ? 1 : 0);
            ps.setInt(26, entity.isInProgress() ? 1 : 0);
            ps.setString(27, entity.getStartYear());
            ps.setInt(28, entity.getEditor());
            ps.setString(29, entity.getDescriptionArm());
            ps.setString(30, entity.getDescriptionRus());
            ps.setString(31, entity.getDescriptionEng());
            ps.setInt(32, entity.getScienceFieldId());
            ps.setString(33, entity.getCover());
            ps.setInt(34, entity.isType() ? 1 : 0);
            ps.setInt(35, entity.getIndexedLibraries());
            ps.setInt(36, entity.getId());
            return ps;
        });
    }

    /**
     * @see Journal#remove(am.bibliographic.entity.Entity)
     */
    @Override
    public void remove(Entity entity) {
        int id = ((JournalEntity) entity).getId();
        final String query = "DELETE FROM journal WHERE id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps;
        });
    }
}
