package am.bibliographic.dao.impl;

import am.bibliographic.dao.JournalEditorBoard;
import am.bibliographic.entity.Entity;
import am.bibliographic.entity.JournalEditorBoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JournalEditorBoardImpl extends NamedParameterJdbcDaoSupport implements JournalEditorBoard {

    @Autowired
    public JournalEditorBoardImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * @see JournalEditorBoard#create(am.bibliographic.entity.JournalEditorBoardEntity)
     */
    @Override
    public int create(JournalEditorBoardEntity entity) {
        return 0;
    }

    /**
     * @see JournalEditorBoard#read(int, int)
     */
    @Override
    public JournalEditorBoardEntity read(int journalId, int editorId) {
        return null;
    }

    /**
     * @see JournalEditorBoard#update(am.bibliographic.entity.JournalEditorBoardEntity)
     */
    @Override
    public void update(JournalEditorBoardEntity entity) {

    }

    /**
     * @see JournalEditorBoard#remove(am.bibliographic.entity.Entity)
     */
    @Override
    public void remove(Entity entity) {

    }
}
