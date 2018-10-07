package july12;


public class OOPsClient {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "A";
		p1.age = 10;
		p1.saysHi();
		
		Person p2 = p1;
		
		p2.age = 20;
		
		System.out.println(p2.age);
		System.out.println(p1.age);
		
		Person p3 = new Person();
		p3.age = 10;
		p3.name = "A";
		
		Person p4 = new Person();
		p4.age = 20;
		p4.name = "B";
		
		System.out.println(p3.age + " " + p3.name);
		System.out.println(p4.age + " " + p4.name);
		Test2(p3,p4);
		System.out.println(p3.age + " " + p3.name);
		System.out.println(p4.age + " " + p4.name);
		
		Person p5 = new Person("A", 10);
		p5.saysHi();
	}
	
	public static void Test2(Person p1, Person p2){
		int tempa = p1.age;
		p1.age = p2.age;
		p2.age = tempa;
		
		p1 = new Person();
		p2 = new Person();
		
		String tempn = p1.name;
		p1.name = p2.name;
		p2.name = tempn;
	}
	
	public static void Test1(Person p1, Person p2){
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

}
