package board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.ReBoardDto;

@Repository
public class BoardDao extends SqlSessionDaoSupport implements BoardDaoInter {

    @Override
    public int getTotalCount() {
        // TODO Auto-generated method stub
        return getSqlSession().selectOne("board.totalCountOfBoard");
    }

    @Override
    public int getNumMax() {
        // TODO Auto-generated method stub
        return getSqlSession().selectOne("board.maxNumOfBoard");
    }

    @Override
    public void updateRestep(int regroup, int restep) {
        // TODO Auto-generated method stub
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("regroup", regroup);
        map.put("restep", restep);

        getSqlSession().selectList("board.updateRestepOfBoard", map);
    }

    @Override
    public int getCheckPass(String num, String pass) {
        // TODO Auto-generated method stub
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("num", num);
        map.put("pass", pass);
        return getSqlSession().selectOne("board.passCheckOfBoard", map);
    }

    @Override
    public void updateReadCount(String num) {
        // TODO Auto-generated method stub
        getSqlSession().update("board.updateReadcountOfBoard", num);
    }

    @Override
    public void insertBoard(ReBoardDto dto) {
        // TODO Auto-generated method stub
        getSqlSession().insert("board.insertOfBoard", dto);
    }

    @Override
    public List<ReBoardDto> getList(int start, int perpage) {
        // TODO Auto-generated method stub
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("start", start);
        map.put("perpage", perpage);

        return getSqlSession().selectList("board.selectAllOfBoard", map);
    }

    @Override
    public ReBoardDto getData(String num) {
        // TODO Auto-generated method stub
        return getSqlSession().selectOne("board.selectOneOfBoard", num);
    }

    @Override
    public void updateBoard(ReBoardDto dto) {
        // TODO Auto-generated method stub
        getSqlSession().update("updateOfBoard", dto);
    }

    @Override
    public void deleteBoard(String num) {
        getSqlSession().delete("board.deleteOfBoard", num);

    }

}
