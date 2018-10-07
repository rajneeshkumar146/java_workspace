package july5;

public class Person {
	int age = -1;
	String name = "NA";
	
	public void saysHello(){
		System.out.println(this.name + "[" + this.age + "] years old says hi");
	}
	
	// constructor -> set properties on object creation
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public Person(){
		
	}
}
