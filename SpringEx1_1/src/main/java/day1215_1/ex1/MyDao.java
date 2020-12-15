package day1215_1.ex1;

public class MyDao implements DaoInter{
    @Override
    public void insertData(String str) {
        System.out.println(str + " Added!!");
    }

    @Override
    public void deleteData(String num) {
        System.out.println(num + " Deleted!!");
    }
}
