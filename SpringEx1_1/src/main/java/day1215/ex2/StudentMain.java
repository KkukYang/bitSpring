package day1215.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

    public static void write(Student s) {
        System.out.println("** print data **");
        System.out.println("name : " + s.getName());
        System.out.println("age : " + s.getAge());
        System.out.println("hobby : " + s.getHobby());
        System.out.println("height, weight : " + s.getHeight() + ", " + s.getWeight());
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/appContext1.xml");

        //자바 클래스에서 설정 후 빈에 데이터 주입시 메스드명이 id가 된다.
        Student s1 = (Student)context.getBean("student1");
        write(s1);

        //기존에 하던 xml 방식으로 데이터 주입후 출력.
        Student s2 = (Student)context.getBean("student2");
        write(s2);
    }
}
