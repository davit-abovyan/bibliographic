package am.bibliographic.dao;

import am.bibliographic.entity.Entity;
import am.bibliographic.entity.JournalEditorBoardEntity;

import java.util.List;

public interface JournalEditorBoard extends BaseDAO {
    /**
     * Adds new record in journal_editor_board table
     * @param entity the entity to be added
     * @return id of the new added entity
     */
    public int create(JournalEditorBoardEntity entity);

    /**
     * Gets the record from journal_editor_board table with provided journal and editor ids
     * @param journalId the journal id which matching entity should be returned considering also editor id
     * @param editorId the editor id which matching entity should be returned considering also journal id
     */
    public JournalEditorBoardEntity read(int journalId, int editorId);


    /**
     * Update the record in journal_editor_board table with details of provided entity
     * @param entity the entity with details to be updated
     */
    public void update(JournalEditorBoardEntity entity);

    /**
     * Removes the record from journal_editor_board table
     * @param entity the entity that should be removed
     */
    public void remove(Entity entity);
}
