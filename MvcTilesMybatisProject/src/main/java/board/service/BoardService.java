package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.BoardDao;
import spring.dto.ReBoardDto;

@Service
public class BoardService implements BoardServiceInter {

    // dao interface 를 구현한 클래스가 자동주입된다.
    // 단 인터페이스를 구현한 클래스가 여러개일 경우 오류가 발생할 수 있다.
    // 이때 @Resource 로 정확한 bean 의 이름을 명시해준다.
    @Autowired
    private BoardDao dao;

    @Override
    public int getTotalCount() {
        return dao.getTotalCount();
    }

    @Override
    public int getNumMax() {
        return dao.getNumMax();
    }

    @Override
    public void updateRestep(int regroup, int restep) {
        dao.updateRestep(regroup, restep);

    }

    @Override
    public int getCheckPass(String num, String pass) {
        return dao.getCheckPass(num, pass);
    }

    @Override
    public void updateReadCount(String num) {
        dao.updateReadCount(num);
    }

    @Override
    public void insertBoard(ReBoardDto dto) {
        // 새글인지 답글인지 판단은 num으로 한다.
        String num = dto.getNum();
        int regroup = dto.getRegroup();
        int restep = dto.getRestep();
        int relevel = dto.getRelevel();

        if (num.equals("0")) { // 새글
            regroup = getNumMax() + 1;
            restep = 0;
            relevel = 0;
        } else { // 답글
            // 답글인경우 같은 그룹증 전달받은 restep 보다 큰값은 모두 1을 증가해서 뒤로 밀리게 한다.
            this.updateRestep(regroup, restep);
            // 그리고 전달받은 step, level을 모두 1 증가해서 db에 저장한다.(그룹값은 그대로 유지)
            restep += 1;
            relevel += 1;
        }

        dto.setRegroup(regroup);
        dto.setRestep(restep);
        dto.setRelevel(relevel);

        dao.insertBoard(dto);
    }

    @Override
    public List<ReBoardDto> getList(int start, int perpage) {
        return dao.getList(start, perpage);
    }

    @Override
    public ReBoardDto getData(String num) {
        return dao.getData(num);
    }

    @Override
    public void updateBoard(ReBoardDto dto) {
        dao.updateBoard(dto);
    }

    @Override
    public void deleteBoard(String num) {
        dao.deleteBoard(num);
    }

}
