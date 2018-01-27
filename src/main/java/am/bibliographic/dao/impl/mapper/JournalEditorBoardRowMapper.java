package am.bibliographic.dao.impl.mapper;

import am.bibliographic.entity.JournalEditorBoardEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalEditorBoardRowMapper implements RowMapper<JournalEditorBoardEntity> {
    @Override
    public JournalEditorBoardEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        JournalEditorBoardEntity journalEditorBoardEntity = new JournalEditorBoardEntity();
        journalEditorBoardEntity.setJournalId(resultSet.getString("journal_id"));
        journalEditorBoardEntity.setEditorId(resultSet.getInt("editor_id"));
        journalEditorBoardEntity.setEditorPositionArm(resultSet.getString("editor_position_arm"));
        journalEditorBoardEntity.setEditorPositionRus(resultSet.getString("editor_position_rus"));
        journalEditorBoardEntity.setEditorPositionEng(resultSet.getString("editor_position_eng"));
        return journalEditorBoardEntity;
    }
}
