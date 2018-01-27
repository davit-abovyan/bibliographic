package am.bibliographic.dao.impl.mapper;

import am.bibliographic.entity.BOHEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BOHRowMapper implements RowMapper<BOHEntity>{
    @Override
    public BOHEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        BOHEntity bohEntity = new BOHEntity();
        bohEntity.setId(resultSet.getInt("id"));
        bohEntity.setName(resultSet.getString("name"));
        return bohEntity;
    }
}
