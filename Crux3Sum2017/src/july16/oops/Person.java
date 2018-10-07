package july16.oops;

public class Person {
	int age = -1;
	String name = "default";

	public void saysHi() {
		System.out.println(this.name + " [" + this.age + "] years says hi");
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public Person() {
	}
}
