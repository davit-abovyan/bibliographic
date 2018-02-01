package am.bibliographic.dao.impl;

import am.bibliographic.dao.Person;
import am.bibliographic.dao.impl.mapper.PersonRowMapper;
import am.bibliographic.entity.Entity;
import am.bibliographic.entity.PersonEntity;
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
public class PersonImpl extends NamedParameterJdbcDaoSupport implements Person {
    @Autowired
    public PersonImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    /**
     * @see Person#create(am.bibliographic.entity.PersonEntity)
     */
    @Override
    public int create(PersonEntity entity) {
        // default return value which means nothing added
        int id = -1;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String query = "INSERT INTO person (name_initial_arm, name_initial_rus, name_initial_eng," +
                " name_final_arm, name_final_rus, name_final_eng, review_state)" +
                " VALUES ( ?, ?, ?, ?, ?, ?, ? )";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getNameInitialArm());
            ps.setString(2, entity.getNameInitialRus());
            ps.setString(3, entity.getNameInitialEng());
            ps.setString(4, entity.getNameFinalArm());
            ps.setString(5, entity.getNameFinalRus());
            ps.setString(6, entity.getNameFinalEng());
            ps.setInt(7, entity.isReviewState() ? 1 : 0);
            return ps;
        },keyHolder);

        if(result == 1){
            id = keyHolder.getKey().intValue();
            entity.setId(id);
        }
        return id;
    }

    /**
     * @see Person#read(int)
     */
    @Override
    public PersonEntity read(int id) {
        final String query = "SELECT * FROM person WHERE id = ? LIMIT 1";
        return getJdbcTemplate().queryForObject(query, new Object[]{id},new PersonRowMapper());
    }

    /**
     * @see Person#getAll()
     */
    @Override
    public List<PersonEntity> getAll() {
        final String query = "SELECT * FROM person";
        return getJdbcTemplate().query(query, new PersonRowMapper());
    }

    /**
     * @see Person#update(am.bibliographic.entity.PersonEntity)
     */
    @Override
    public void update(PersonEntity entity) {
        final String query = "UPDATE person SET name_initial_arm = ?, name_initial_rus = ?, name_initial_eng = ?," +
                " name_final_arm = ?, name_final_rus = ?, name_final_eng = ?, review_state = ? " +
                " WHERE id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getNameInitialArm());
            ps.setString(2, entity.getNameInitialRus());
            ps.setString(3, entity.getNameInitialEng());
            ps.setString(4, entity.getNameFinalArm());
            ps.setString(5, entity.getNameFinalRus());
            ps.setString(6, entity.getNameFinalEng());
            ps.setInt(7, entity.isReviewState() ? 1 : 0);
            ps.setInt(8, entity.getId());
            return ps;
        });
    }

    /**
     * @see Person#remove(int)
     */
    @Override
    public void remove(int id) {
        final String query = "DELETE FROM person WHERE id = ? ";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps;
        });
        if(result != 1) throw new NoSuchRecordToRemove("Person with id "+id+" doesn't exist to be removed.");
    }
}
