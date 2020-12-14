package ex4.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("config/rootContext.xml");
		DataSource oraSource = (DataSource)context.getBean("oraclesource");
		oraSource.serverInfo();
	}

}
