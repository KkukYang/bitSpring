package day1215_1.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("list") //id가 "list" 가 됨.
@Component
public class ListController {

    //@Resource(name="dao") //해당 id를 찾아 주입.
    @Autowired  //해당 타입을 찾아서 자동으로 주입시켜줌.
    DaoInter daoInter;

//    public ListController(DaoInter daoInter) {
//        this.daoInter = daoInter;
//    }

    public void process(){
        System.out.println("insert into DB");
        daoInter.insertData("happy Day");

        System.out.println("delete DB");
        daoInter.deleteData("5");
    }
}
