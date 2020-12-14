package ex1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello h1 = new Hello();
		System.out.println(h1.getMessage());

		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		// Hello h2 = (Hello)context.getBean("hello");//방법1.
		Hello h2 = context.getBean("hello", Hello.class); // 방법2.
		Hello hh2 = context.getBean("hello", Hello.class);

		System.out.println(h2.hashCode());
		System.out.println(hh2.hashCode());
		
		System.out.println(h2.getMessage());
		System.out.println(hh2.getMessage());

	}

}
