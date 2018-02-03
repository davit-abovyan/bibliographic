package am.bibliographic.dao.impl.mapper;

import am.bibliographic.entity.StatisticsEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsRowMapper implements RowMapper<StatisticsEntity> {
    @Override
    public StatisticsEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StatisticsEntity statisticsEntity = new StatisticsEntity();
        statisticsEntity.setJournalId(resultSet.getInt("journal_id"));
        statisticsEntity.setIF2010(resultSet.getInt("IF_2010"));
        statisticsEntity.setIF2011(resultSet.getInt("IF_2011"));
        statisticsEntity.setIF2012(resultSet.getInt("IF_2012"));
        statisticsEntity.setIF2013(resultSet.getInt("IF_2013"));
        statisticsEntity.setIF2014(resultSet.getInt("IF_2014"));
        statisticsEntity.setIF2015(resultSet.getInt("IF_2015"));
        statisticsEntity.setIF2016(resultSet.getInt("IF_2016"));
        statisticsEntity.setIF2017(resultSet.getInt("IF_2017"));
        statisticsEntity.setIF2018(resultSet.getInt("IF_2018"));
        statisticsEntity.setIF2019(resultSet.getInt("IF_2019"));
        statisticsEntity.setIF2020(resultSet.getInt("IF_2020"));
        statisticsEntity.setnIssueElib(resultSet.getInt("n_issue_elib"));
        statisticsEntity.setnIssueAINC(resultSet.getInt("n_issue_AINC"));
        statisticsEntity.setnArticleElib(resultSet.getInt("n_article_elib"));
        statisticsEntity.setnArticleAINC(resultSet.getInt("n_article_AINC"));
        statisticsEntity.setnReferenceAINC(resultSet.getInt("n_reference_AINC"));
        statisticsEntity.setnCitationAINC(resultSet.getInt("n_citation_AINC"));
        statisticsEntity.setnSelfciteAINC(resultSet.getInt("n_selfcite_AINC"));
        return statisticsEntity;
    }
}
