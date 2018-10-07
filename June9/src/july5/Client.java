package july5;

public class Client {

	public static void main(String[] args) {
//		Person p1 = new Person();
//		p1.age = 10;
//		p1.name = "A";
//		
//		p1.saysHello();
//		
//		Person p2 = p1;
//		p2.age = 20;
//		
//		p2.saysHello();
//		p1.saysHello();
		
		Person p1 = new Person(10, "A");
//		p1.age = 10;
//		p1.name = "A";
		
		Person p2 = new Person(20, "B");
//		p2.age = 20;
//		p2.name = "B";
		
		p1.saysHello();
		p2.saysHello();
		swap2(p1, p2);
		p1.saysHello();
		p2.saysHello();
	}
	
	private static void swap2(Person p1, Person p2){
		int tage = p1.age;
		p1.age = p2.age;
		p2.age = tage;
		
		p2 = new Person();
		p1 = new Person();
		
		String tname = p1.name;
		p1.name = p2.name;
		p2.name = tname;
	}

	private static void swap1(Person p1, Person p2) {
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

}
