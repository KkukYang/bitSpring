package day1214.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		Sawon s1 = context.getBean("sawon", Sawon.class);
		s1.show();

		EmpPay emp = context.getBean("emp", EmpPay.class);
		emp.write();
	}

}
