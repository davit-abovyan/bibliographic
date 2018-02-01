package am.bibliographic.dao.impl;

import am.bibliographic.dao.ScienceField;
import am.bibliographic.dao.impl.mapper.ScienceFieldRowMapper;
import am.bibliographic.entity.Entity;
import am.bibliographic.entity.ScienceFieldEntity;
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
public class ScienceFieldImpl extends NamedParameterJdbcDaoSupport implements ScienceField {

    @Autowired
    public ScienceFieldImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * @see ScienceField#create(am.bibliographic.entity.ScienceFieldEntity)
     */
    @Override
    public int create(ScienceFieldEntity entity) {
        // default return value which means nothing added
        int id = -1;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String query = "INSERT INTO science_field (name_arm, name_rus, name_eng)" +
                " VALUES ( ?, ?, ? )";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getNameArm());
            ps.setString(2, entity.getNameRus());
            ps.setString(3, entity.getNameEng());
            return ps;
        },keyHolder);

        if(result == 1){
            id = keyHolder.getKey().intValue();
            entity.setId(id);
        }
        return id;
    }

    /**
     * @see ScienceField#read(int)
     */
    @Override
    public ScienceFieldEntity read(int id) {
        final String query = "SELECT * FROM science_field WHERE id = ? LIMIT 1";
        return getJdbcTemplate().queryForObject(query, new Object[]{id},new ScienceFieldRowMapper());
    }

    /**
     * @see ScienceField#getAll()
     */
    @Override
    public List<ScienceFieldEntity> getAll() {
        final String query = "SELECT * FROM science_field";
        return getJdbcTemplate().query(query, new ScienceFieldRowMapper());
    }

    /**
     * @see ScienceField#update(am.bibliographic.entity.ScienceFieldEntity)
     */
    @Override
    public void update(ScienceFieldEntity entity) {
        final String query = "UPDATE science_field SET name_arm = ?, name_rus = ?, name_eng = ? " +
                " WHERE id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getNameArm());
            ps.setString(2, entity.getNameRus());
            ps.setString(3, entity.getNameEng());
            ps.setInt(4, entity.getId());
            return ps;
        });
    }

    /**
     * @see ScienceField#remove(int)
     */
    @Override
    public void remove(int id) {
        final String query = "DELETE FROM science_field WHERE id = ? ";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps;
        });
        if(result != 1) throw new NoSuchRecordToRemove("ScienceField with id "+id+" doesn't exist to be removed.");
    }
}
