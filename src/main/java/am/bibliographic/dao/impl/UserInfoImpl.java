package am.bibliographic.dao.impl;

import am.bibliographic.dao.UserInfo;
import am.bibliographic.dao.impl.mapper.UserRowMapper;
import am.bibliographic.entity.UserEntity;
import am.bibliographic.exception.NoSuchRecordToRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Component
public class UserInfoImpl extends NamedParameterJdbcDaoSupport implements UserInfo {

    @Autowired
    public UserInfoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * @see UserInfo#create(am.bibliographic.entity.UserEntity)
     */
    @Override
    public boolean create(UserEntity entity) {
        final String query = "INSERT INTO users (username, password, authority, enabled)" +
                " VALUES ( ?, ?, ?, ? )";
        return getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getRole());
            ps.setString(4, entity.getUsername());
            return ps;
        }) == 1;
    }

    /**
     * @see UserInfo#read(java.lang.String)
     */
    @Override
    public UserEntity read(String userName) {
        final String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        return getJdbcTemplate().queryForObject(query, new Object[]{userName},new UserRowMapper());
    }

    /**
     * @see UserInfo#getAll()
     */
    @Override
    public List<UserEntity> getAll() {
        final String query = "SELECT * FROM users ORDER BY username DESC ";
        return getJdbcTemplate().query(query, new UserRowMapper());
    }

    /**
     * @see UserInfo#update(am.bibliographic.entity.UserEntity)
     */
    @Override
    public void update(UserEntity entity) {
        final String query = "UPDATE users SET password = ?, authority = ?, enabled = ? " +
                " WHERE username = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getPassword());
            ps.setString(2, entity.getRole());
            ps.setBoolean(3, entity.isEnabled());
            ps.setString(4, entity.getUsername());
            return ps;
        });
    }

    /**
     * @see UserInfo#remove(java.lang.String)
     */
    @Override
    public void remove(String userName) {
        final String query = "DELETE FROM users WHERE username = ? ";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            return ps;
        });
        if(result != 1) throw new NoSuchRecordToRemove("UserInfo with id "+userName+" doesn't exist to be removed.");
    }
}
