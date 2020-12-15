package day1215_1.ex1;

public class ListController {
    DaoInter daoInter;

    public ListController(DaoInter daoInter) {
        this.daoInter = daoInter;
    }

    public void process(){
        System.out.println("insert into DB");
        daoInter.insertData("happy Day");

        System.out.println("delete DB");
        daoInter.deleteData("5");
    }
}
