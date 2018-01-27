package am.bibliographic.dao.impl.mapper;

import am.bibliographic.entity.ScienceFieldEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScienceFieldRowMapper implements RowMapper<ScienceFieldEntity> {
    @Override
    public ScienceFieldEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        ScienceFieldEntity scienceFieldEntity = new ScienceFieldEntity();
        scienceFieldEntity.setId(resultSet.getInt("id"));
        scienceFieldEntity.setNameArm(resultSet.getString("name_arm"));
        scienceFieldEntity.setNameRus(resultSet.getString("name_rus"));
        scienceFieldEntity.setNameEng(resultSet.getString("name_eng"));
        return scienceFieldEntity;
    }
}
