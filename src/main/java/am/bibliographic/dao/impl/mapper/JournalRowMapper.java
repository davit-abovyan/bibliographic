package am.bibliographic.dao.impl.mapper;

import am.bibliographic.constants.Country;
import am.bibliographic.constants.Language;
import am.bibliographic.entity.JournalEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalRowMapper implements RowMapper<JournalEntity> {
    @Override
    public JournalEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        JournalEntity journalEntity = new JournalEntity();
        journalEntity.setId(resultSet.getInt("id"));
        journalEntity.setCode(resultSet.getString("code"));
        journalEntity.setOperatorId(resultSet.getInt("operator"));
        journalEntity.setNameArm(resultSet.getString("name_arm"));
        journalEntity.setNameRus(resultSet.getString("name_rus"));
        journalEntity.setNameEng(resultSet.getString("name_eng"));
        journalEntity.setFullNameArm(resultSet.getString("full_name_arm"));
        journalEntity.setFullNameRus(resultSet.getString("full_name_rus"));
        journalEntity.setFullNameEng(resultSet.getString("full_name_eng"));
        journalEntity.setISSNPrint(resultSet.getString("ISSN_print"));
        journalEntity.setISBN(resultSet.getString("ISBN"));
        journalEntity.setFounderArm(resultSet.getString("founder_arm"));
        journalEntity.setPublisherArm(resultSet.getString("publisher_arm"));
        journalEntity.setPublisherRus(resultSet.getString("publisher_rus"));
        journalEntity.setPublisherEng(resultSet.getString("publisher_eng"));
        journalEntity.setPhone(resultSet.getString("phone"));
        journalEntity.setFax(resultSet.getString("fax"));
        journalEntity.setEmail(resultSet.getString("email"));
        journalEntity.setWebsite(resultSet.getString("website"));
        journalEntity.setCountry(Country.valueOf(resultSet.getString("country").toUpperCase()));
        journalEntity.setCity(resultSet.getString("city"));
        journalEntity.setAddress(resultSet.getString("address"));
        journalEntity.setFrequency(resultSet.getInt("frequency"));
        journalEntity.setLanguage(resultSet.getInt("language"));
        journalEntity.setJournalCategory(resultSet.getString("journal_category"));
        journalEntity.setReviewed(resultSet.getBoolean("reviewed"));
        journalEntity.setInProgress(resultSet.getBoolean("in_progress"));
        journalEntity.setStartYear(resultSet.getString("start_year"));
        journalEntity.setEditor(resultSet.getInt("editor"));
        journalEntity.setDescriptionArm(resultSet.getString("description_arm"));
        journalEntity.setDescriptionRus(resultSet.getString("description_rus"));
        journalEntity.setDescriptionEng(resultSet.getString("description_eng"));
        journalEntity.setScienceFieldId(resultSet.getInt("science_field_id"));
        journalEntity.setCover(resultSet.getString("cover"));
        journalEntity.setType(resultSet.getBoolean("type"));
        journalEntity.setIndexedLibraries(resultSet.getInt("indexed_libraries"));
        return journalEntity;
    }
}
