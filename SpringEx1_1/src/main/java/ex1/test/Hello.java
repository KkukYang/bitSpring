package ex1.test;

public class Hello {

	String name;
	int age;

	public Hello() {
		this.name = "홍길동";
		this.age = 21;
	}

	public String getMessage() {
		return "내 이름은 " + name + "이고 " + age + "세 입니다.";
	}

}
