package day1215_di.ex2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

//스프링 설정에 사용되는 클래스라고 알려주는 어노테이션.
@Configuration
public class ApplicationConfig {

    //bean 객체 설정.
    @Bean
    public Student2 student1() {
        ArrayList<String> hobby = new ArrayList<String>();
        hobby.add("스프링 공부");
        hobby.add("자바 공부");
        hobby.add("리액트 공부");

        Student2 s1 = new Student2("아이유", 23, hobby);
        s1.setHeight(165.8);
        s1.setWeight(57.9);

        return s1;
    }
}
