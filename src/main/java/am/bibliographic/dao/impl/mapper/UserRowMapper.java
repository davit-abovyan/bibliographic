package am.bibliographic.dao.impl.mapper;

import am.bibliographic.entity.BOHEntity;
import am.bibliographic.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity>{
    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(resultSet.getString("username"));
        userEntity.setPassword(resultSet.getString("password"));
        userEntity.setEnabled(resultSet.getBoolean("enabled"));
        userEntity.setRole(resultSet.getString("authority"));
        return userEntity;
    }
}
