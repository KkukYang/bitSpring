package board.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import spring.dto.ReAnswerDto;

import java.util.List;

@Repository
public class AnswerDao extends SqlSessionDaoSupport {

    public void insertAnswer(ReAnswerDto dto) {
        getSqlSession().insert("answer.insertOfAnswer", dto);
    }

    public List<ReAnswerDto> getAnswerList(String num) {
        return getSqlSession().selectList("answer.selectAllOfAnswer", num);
    }

    public void deleteAnswer(String idx) {
        getSqlSession().delete("answer.deleteOfAnswer", idx);
    }

    public void updateAnswer(ReAnswerDto dto) {
        getSqlSession().update("answer.updateOfAnswer", dto);
    }

    public ReAnswerDto getData(String idx){
        return getSqlSession().selectOne("answer.selectOneOfAnswer", idx);
    }
}
