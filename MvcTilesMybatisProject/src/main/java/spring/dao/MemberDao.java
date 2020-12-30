package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MemberDto;

@Repository
public class MemberDao extends SqlSessionDaoSupport {

	public int idCheck(String myid) {
		return getSqlSession().selectOne("member.idCheckOfMember", myid);
	}

	public void insertMember(MemberDto dto) {
		getSqlSession().insert("member.insertOfMember", dto);
	}

	public List<MemberDto> getAllMember() {
		return getSqlSession().selectList("member.selectAllOfMember");
	}

	public MemberDto getMember(String num) {
		return getSqlSession().selectOne("member.selectOneOfMember", num);
	}

	public void updateMember(MemberDto dto) {
		getSqlSession().update("member.updateOfMember", dto);
	}

	public int getPassIsCheck(String num, String pass) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("num", num);
		map.put("pass", pass);

		return getSqlSession().selectOne("passCheckOfMember", map);
	}

	public void deleteMember(String num) {
		getSqlSession().delete("member.deleteOfMember", num);
	}

}
