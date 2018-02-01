package am.bibliographic.dao.impl;

import am.bibliographic.dao.BohJournal;
import am.bibliographic.dao.impl.mapper.BohJournalRowMapper;
import am.bibliographic.entity.BohJournalEntity;
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
public class BohJournalImpl extends NamedParameterJdbcDaoSupport implements BohJournal {

    @Autowired
    public BohJournalImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * @see BohJournal#create(am.bibliographic.entity.BohJournalEntity)
     */
    @Override
    public boolean create(BohJournalEntity entity) {
        final String query = "INSERT  INTO boh_journal (journal_id, boh_id)" +
                " VALUES ( ?, ? )";
        return getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, entity.getJournalId());
            ps.setInt(2, entity.getBohId());
            return ps;
        }) == 1;
    }

    /**
     * @see BohJournal#getByJournal(int)
     */
    @Override
    public List<BohJournalEntity> getByJournal(int journalId) {
        final String query = "SELECT * FROM boh_journal WHERE journal_id = ? ";
        return getJdbcTemplate().query(query,new Object[]{journalId}, new BohJournalRowMapper());
    }

    /**
     * @see BohJournal#getByBoh(int)
     */
    @Override
    public List<BohJournalEntity> getByBoh(int bohId) {
        final String query = "SELECT * FROM boh_journal WHERE boh_id = ? ";
        return getJdbcTemplate().query(query,new Object[]{bohId}, new BohJournalRowMapper());
    }

    /**
     * @see BohJournal#getByBOHAndJournal(int, int)
     */
    @Override
    public boolean getByBOHAndJournal(int bohId, int journalId) {
        final String query = "SELECT * FROM boh_journal WHERE boh_id = ? AND journal_id = ? ";
        return getJdbcTemplate().query(query,new Object[]{bohId, journalId}, new BohJournalRowMapper()).size() == 1;
    }

    /**
     * @see BohJournal#remove(am.bibliographic.entity.Entity)
     */
    @Override
    public void remove(Entity entity) {
        BohJournalEntity bohJournalEntity = (BohJournalEntity) entity;
        int bohId = bohJournalEntity.getBohId();
        int journalId = bohJournalEntity.getJournalId();
        final String query = "DELETE FROM boh_journal WHERE boh_id = ? AND journal_id = ?";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bohId);
            ps.setInt(2, journalId);
            return ps;
        });
    }

    /**
     * @see BohJournal#removeByJournal(int)
     */
    @Override
    public void removeByJournal(int id) {
        final String query = "DELETE FROM boh_journal WHERE journal_id = ?";
        int result = getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps;
        });
        if(result != 1) throw new NoSuchRecordToRemove("Record in BohJournal with Journal id "+id+" doesn't exist to be removed.");
    }
}
