package day1215_annotation.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3Main {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("config/1215_1_ex1_appContext.xml");

//        ListController listCont = (ListController)context.getBean("list");
        ListController listCont = (ListController)context.getBean("listController");
        listCont.process();
    }
}
