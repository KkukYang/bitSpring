# bitSpring
***
##### setting sts3
* [pom.xml](https://github.com/KkukYang/bitSpring/blob/main/SpringEx1_1/pom.xml)
* 
***
20201214
# DI(Dependency Injection)
Sawon.java
```
package ex2.test;

public class Sawon {
    String name, hp, addr;

    public Sawon(String name) {

        this.name = name;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void show() {
        System.out.println("name : " + name);
        System.out.println("hp : " + hp);
        System.out.println("addr : " + addr);
    }

}
```
***
EmpPay.java
```
package ex2.test;

public class EmpPay {
    Sawon sawon;
    int pay;

    public EmpPay(Sawon sawon) {
        this.sawon = sawon;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public void write() {
        System.out.println("** Sawon Info **");
        sawon.show();
        System.out.println("** Salary this Month **");
        System.out.println(pay);
    }
}

```
***
appContext.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="hello" class="ex1.test.Hello" scope="prototype" />

	<!-- 사원등록 -->
	<bean id="sawon" class="ex2.test.Sawon">
		<!--constructor value is param-->
		<!--<constructor-arg value="강호동"></constructor-arg>-->

		<!--이것도 가능. name is paramName-->
		<constructor-arg name="name">
			<value>강호동</value>
		</constructor-arg>

		<!--property member value-->
		<property name="hp">
			<value>010-1234-1234</value>
		</property>
		<property name="addr">
			<value>asdfasdfasdf</value>
		</property>
	</bean>

	<bean id="sawon2" class="ex2.test.Sawon">
		<constructor-arg value="강민수"></constructor-arg>
		<property name="hp">
			<value>010-4566-4566</value>
		</property>
		<property name="addr">
			<value>zxcvzxcvzxcv</value>
		</property>
	</bean>

	<bean id="emp" class="ex2.test.EmpPay">
		<!--ref is classObj by param-->
		<constructor-arg ref="sawon2" />
		<property name="pay" value="3456789" />
	</bean>

</beans>
```
***

