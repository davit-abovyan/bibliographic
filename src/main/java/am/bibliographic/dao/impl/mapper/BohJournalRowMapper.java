package am.bibliographic.dao.impl.mapper;

import am.bibliographic.entity.crosstable.BohJournalEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BohJournalRowMapper implements RowMapper<BohJournalEntity> {
    @Override
    public BohJournalEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        BohJournalEntity bohJournalEntity = new BohJournalEntity();
        bohJournalEntity.setJournalId(resultSet.getInt("journal_id"));
        bohJournalEntity.setBohId(resultSet.getInt("boh_id"));
        return bohJournalEntity;
    }
}
