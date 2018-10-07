package Opps.Constructor;

public class Person {

	// private int age = -1;
	// private String name = "NA";

	private static int age = -1;
	private static String name = "NA";

	public void SaysHello() {
		System.out.println(this.name + "[" + age + "] ");
	}

	static {
		System.out.println(name + "{" + age + "] ");

	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public Person() {

	}

}
