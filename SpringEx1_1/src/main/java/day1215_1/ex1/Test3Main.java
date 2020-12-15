package day1215_1.ex1;

import day1215.ex2.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3Main {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("config/1215_1_ex1_appContext.xml");

        ListController listCont = (ListController)context.getBean("list");
        listCont.process();
    }
}
