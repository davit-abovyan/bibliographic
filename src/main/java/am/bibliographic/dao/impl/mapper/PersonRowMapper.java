package am.bibliographic.dao.impl.mapper;

import am.bibliographic.entity.PersonEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<PersonEntity> {
    @Override
    public PersonEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(resultSet.getInt("id"));
        personEntity.setNameInitialArm(resultSet.getString("name_initial_arm"));
        personEntity.setNameInitialRus(resultSet.getString("name_initial_rus"));
        personEntity.setNameInitialEng(resultSet.getString("name_initial_eng"));
        personEntity.setNameFinalArm(resultSet.getString("name_final_arm"));
        personEntity.setNameFinalRus(resultSet.getString("name_final_rus"));
        personEntity.setNameFinalEng(resultSet.getString("name_final_eng"));
        personEntity.setInReviewState(resultSet.getBoolean("review_state"));
        return personEntity;
    }
}
