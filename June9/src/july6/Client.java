package july6;

public class Client {

	public static void main(String[] args) {
//		C obj = new C();
//		obj.Fun();
//		obj.Fun1();
//		System.out.println(obj.d);
//		System.out.println(obj.d1);
		
		// Compiler -> reference, JVM -> instance
		P o1 = new P();
		P o2 = new C();
//		C o3 = new P(); potential runtime errors
		C o4 = new C();
		
		// p -> p
		System.out.println(o1.d);
		System.out.println(o1.d1);
//		System.out.println(o1.d2);
		o1.Fun(); 
		o1.Fun1();
//		o1.Fun2();
		
		// p -> c
		System.out.println("-------------------");
		System.out.println(o2.d);
		System.out.println(o2.d1);
//		System.out.println(o2.d2);
		o2.Fun(); // C's fun override P's fun
		o2.Fun1(); 
//		o2.Fun2();
		
		// c -> c
		System.out.println("-------------------");
		System.out.println(o4.d);
		System.out.println(o4.d1);
		System.out.println(o4.d2);
		o4.Fun(); 
		o4.Fun1(); 
		o4.Fun2();
	}

}
