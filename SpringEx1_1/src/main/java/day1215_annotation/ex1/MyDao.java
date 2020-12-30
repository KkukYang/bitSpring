package day1215_annotation.ex1;

import org.springframework.stereotype.Component;

//@Component : 자동으로 설정파일에 bean 등록해주는 어노테이션.
//@Component : 클래스 명이 아이디가 된다.(단, 첫글자는 소문자 "myDao" 가 id 로 됨.
@Component("dao") //dao 가 id 로 됨.
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
