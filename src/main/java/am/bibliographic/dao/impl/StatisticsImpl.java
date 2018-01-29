package am.bibliographic.dao.impl;

import am.bibliographic.dao.Statistics;
import am.bibliographic.dao.impl.mapper.StatisticsRowMapper;
import am.bibliographic.entity.Entity;
import am.bibliographic.entity.StatisticsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
@Component
public class StatisticsImpl extends NamedParameterJdbcDaoSupport implements Statistics {

    @Autowired
    public StatisticsImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    /**
     * @see Statistics#create(am.bibliographic.entity.StatisticsEntity)
     */
    @Override
    public void create(StatisticsEntity entity) {
        final String query = "INSERT INTO statistics (journal_id, IF_2010, IF_2011, IF_2012, IF_2013, IF_2014, IF_2015," +
                " n_issue_elib, n_issue_AINC, n_article_elib, n_article_AINC, n_reference_AINC, n_citation_AINC, n_selfcite_AINC)" +
                " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, entity.getJournalId());
            ps.setInt(2, entity.getIF_2010());
            ps.setInt(3, entity.getIF_2011());
            ps.setInt(4, entity.getIF_2012());
            ps.setInt(5, entity.getIF_2013());
            ps.setInt(6, entity.getIF_2014());
            ps.setInt(7, entity.getIF_2015());
            ps.setInt(8, entity.getnIssueElib());
            ps.setInt(9, entity.getnArticleAINC());
            ps.setInt(10, entity.getnArticleElib());
            ps.setInt(11, entity.getnArticleAINC());
            ps.setInt(12, entity.getnReferenceAINC());
            ps.setInt(13, entity.getnCitationAINC());
            ps.setInt(14, entity.getnSelfciteAINC());
            return ps;
        });
    }

    /**
     * @see Statistics#read(int)
     */
    @Override
    public StatisticsEntity read(int id) {
        final String query = "SELECT * FROM statistics WHERE journal_id = ? LIMIT 1";
        return getJdbcTemplate().queryForObject(query, new Object[]{id},new StatisticsRowMapper());
    }

    /**
     * @see Statistics#getAll()
     */
    @Override
    public List<StatisticsEntity> getAll() {
        final String query = "SELECT * FROM statistics";
        return getJdbcTemplate().query(query, new StatisticsRowMapper());
    }

    /**
     * @see Statistics#update(am.bibliographic.entity.StatisticsEntity)
     */
    @Override
    public void update(StatisticsEntity entity) {
        final String query = "UPDATE statistics SET IF_2010 = ?, IF_2011 = ?, IF_2012 = ?," +
                " IF_2013 = ?, IF_2014 = ?, IF_2015 = ?, n_issue_elib = ?, n_issue_AINC = ?, n_article_elib = ?," +
                " n_article_AINC = ?, n_reference_AINC = ?, n_citation_AINC = ?, n_selfcite_AINC = ? " +
                " WHERE journal_id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, entity.getIF_2010());
            ps.setInt(2, entity.getIF_2011());
            ps.setInt(3, entity.getIF_2012());
            ps.setInt(4, entity.getIF_2013());
            ps.setInt(5, entity.getIF_2014());
            ps.setInt(6, entity.getIF_2015());
            ps.setInt(7, entity.getnIssueElib());
            ps.setInt(8, entity.getnIssueAINC());
            ps.setInt(9, entity.getnArticleElib());
            ps.setInt(10, entity.getnArticleAINC());
            ps.setInt(11, entity.getnReferenceAINC());
            ps.setInt(12, entity.getnCitationAINC());
            ps.setInt(13, entity.getnSelfciteAINC());
            ps.setInt(14, entity.getJournalId());
            return ps;
        });
    }

    /**
     * @see Statistics#remove(am.bibliographic.entity.Entity)
     */
    @Override
    public void remove(Entity entity) {
        int id = ((StatisticsEntity) entity).getJournalId();
        final String query = "DELETE FROM statistics WHERE journal_id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps;
        });
    }

    /**
     * @see Statistics#remove(int)
     */
    @Override
    public void remove(int journalId) {
        final String query = "DELETE FROM statistics WHERE journal_id = ? ";
        getJdbcTemplate().update( connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, journalId);
            return ps;
        });
    }
}
