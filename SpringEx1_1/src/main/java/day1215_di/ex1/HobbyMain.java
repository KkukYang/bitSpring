package day1215_di.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HobbyMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/appContext1.xml");
        Hobby h1 = (Hobby) context.getBean("hobby");
        h1.write();
    }
}
