package am.bibliographic.dao.impl;

import am.bibliographic.dao.BOH;
import am.bibliographic.dao.impl.mapper.BOHRowMapper;
import am.bibliographic.entity.BOHEntity;
import am.bibliographic.entity.Entity;
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
public class BOHImpl extends NamedParameterJdbcDaoSupport implements BOH {

    @Autowired
    public BOHImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * @see BOH#create(am.bibliographic.entity.BOHEntity)
     */
    @Override
    public int create(BOHEntity entity) {
        // default return value which means nothing added
        int id = -1;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String query = "INSERT  INTO boh (name)" +
                " VALUES ( ? )";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getName());
            return ps;
        },keyHolder);

        if(result == 1){
            id = keyHolder.getKey().intValue();
            entity.setId(id);
        }
        return id;
    }

    /**
     * @see BOH#read(int)
     */
    @Override
    public BOHEntity read(int id) {
        final String query = "SELECT * FROM boh WHERE id = ? LIMIT 1";
        return getJdbcTemplate().queryForObject(query, new Object[]{id},new BOHRowMapper());
    }

    /**
     * @see BOH#getAll()
     */
    @Override
    public List<BOHEntity> getAll() {
        final String query = "SELECT * FROM boh";
        return getJdbcTemplate().query(query, new BOHRowMapper());
    }

    /**
     * @see BOH#update(am.bibliographic.entity.BOHEntity)
     */
    @Override
    public void update(BOHEntity entity) {
        final String query = "UPDATE boh SET name = ? " +
                " WHERE id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());
            return ps;
        });
    }

    /**
     * @see BOH#remove(int)
     */
    @Override
    public void remove(int id) {
        final String query = "DELETE FROM boh WHERE id = ? ";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps;
        });
        if(result != 1) throw new NoSuchRecordToRemove("BOH with id "+id+" doesn't exist to be removed.");
    }
}
