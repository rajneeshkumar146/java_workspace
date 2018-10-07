package july19;

public class Person {
	int age = -1;
	String name = "default";
	
	public void saysHi(){
		System.out.println(this.name + "[" + this.age + "] years old says hi");
	}
	
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}
}
