package july12;


public class Person {
	String name = "default";
	int age = -1;
	
	public void saysHi(){
		System.out.println(this.name + " [" + this.age + "] years old says hello");
	}
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public Person(){
		
	}
}
