package am.bibliographic.dao.impl;

import am.bibliographic.dao.Operator;
import am.bibliographic.dao.impl.mapper.OperatorRowMapper;
import am.bibliographic.entity.Entity;
import am.bibliographic.entity.OperatorEntity;
import am.bibliographic.exception.NoSuchRecordToRemove;
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
public class OperatorImpl extends NamedParameterJdbcDaoSupport implements Operator {

    @Autowired
    public OperatorImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * @see Operator#create(am.bibliographic.entity.OperatorEntity)
     */
    @Override
    public int create(OperatorEntity entity) {
        // default return value which means nothing added
        int id = -1;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String query = "INSERT INTO operator (name, is_reviewer)" +
                " VALUES ( ?, ? )";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getName());
            ps.setBoolean(2, entity.isIs_reviewer());
            return ps;
        }, keyHolder);

        if(result == 1){
            id = keyHolder.getKey().intValue();
            entity.setId(id);
        }
        return id;
    }

    /**
     * @see Operator#read(int)
     */
    @Override
    public OperatorEntity read(int id) {
        final String query = "SELECT * FROM operator WHERE id = ? LIMIT 1";
        return getJdbcTemplate().queryForObject(query, new Object[]{id},new OperatorRowMapper());
    }

    /**
     * @see Operator#getAll()
     */
    @Override
    public List<OperatorEntity> getAll() {
        final String query = "SELECT * FROM operator";
        return getJdbcTemplate().query(query, new OperatorRowMapper());
    }

    /**
     * @see Operator#update(am.bibliographic.entity.OperatorEntity)
     */
    @Override
    public void update(OperatorEntity entity) {
        final String query = "UPDATE operator SET name = ?, is_reviewer = ? " +
                " WHERE id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getName());
            ps.setBoolean(2, entity.isIs_reviewer());
            ps.setInt(3, entity.getId());
            return ps;
        });
    }

    /**
     * @see Operator#remove(am.bibliographic.entity.Entity)
     */
    @Override
    public void remove(int id) {
        final String query = "DELETE FROM operator WHERE id = ? ";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps;
        });
        if(result != 1) throw new NoSuchRecordToRemove("BOH with id "+id+" doesn't exist to be removed.");
    }
}
