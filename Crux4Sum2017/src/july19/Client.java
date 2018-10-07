package july19;

public class Client {

	public static void main(String[] args) {
		// Person p1 = new Person(); // instance and reference (object)
		// p1.age = 10;
		// p1.name = "A";
		//
		// p1.saysHi();
		//
		// Person p2 = p1;
		//
		// p2.name = "B";
		// p2.age = 20;
		//
		// p1.saysHi();

//		Person p1 = new Person();
//		p1.age = 10;
//		p1.name = "A";
//
//		Person p2 = new Person();
//		p2.age = 20;
//		p2.name = "B";
//
//		System.out.println(p1.age + ", " + p1.name);
//		System.out.println(p2.age + ", " + p2.name);
//		Test2(p1, p2);
//		System.out.println(p1.age + ", " + p1.name);
//		System.out.println(p2.age + ", " + p2.name);
		
		Person p = new Person(10, "A");
		p.saysHi();
		
	}

//	public static void Test2(Person p1, Person p2) {
//		int tempa = p1.age;
//		p1.age = p2.age;
//		p2.age = tempa;
//		
//		p2 = new Person();
//		p1 = new Person();
//
//		String tempn = p1.name;
//		p1.name = p2.name;
//		p2.name = tempn;
//	}
//
//	public static void Test1(Person p1, Person p2) {
//		Person temp = p1;
//		p1 = p2;
//		p2 = temp;
//	}

}
