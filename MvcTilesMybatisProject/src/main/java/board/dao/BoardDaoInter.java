package board.dao;

import java.util.List;

import spring.dto.ReBoardDto;

public interface BoardDaoInter {
	int getNumMax();

	int getTotalCount();
	
	void updateRestep(int regroup, int restep);

	int getCheckPass(String num, String pass);

	void updateReadCount(String num);

	void insertBoard(ReBoardDto dto);

	List<ReBoardDto> getList(int start, int perpage);

	ReBoardDto getData(String num);

	void updateBoard(ReBoardDto dto);

	void deleteBoard(String num);
}
