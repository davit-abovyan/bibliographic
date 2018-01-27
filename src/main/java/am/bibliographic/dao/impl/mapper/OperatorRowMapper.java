package am.bibliographic.dao.impl.mapper;

import am.bibliographic.entity.OperatorEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperatorRowMapper implements RowMapper<OperatorEntity> {
    @Override
    public OperatorEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        OperatorEntity operatorEntity = new OperatorEntity();
        operatorEntity.setId(resultSet.getInt("id"));
        operatorEntity.setName(resultSet.getString("name"));
        operatorEntity.setIs_reviewer(resultSet.getBoolean("is_reviewer"));
        return operatorEntity;
    }
}
