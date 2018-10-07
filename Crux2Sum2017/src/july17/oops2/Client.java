package july17.oops2;

public class Client {

	public static void main(String[] args) {
//		C obj = new C();
//		obj.d
		
		// Case 1
		P o1 = new P();
		
		System.out.println(o1.d);
		System.out.println(o1.d1);
//		System.out.println(o1.d2); // compiler could not find d2
		
		o1.Fun();
		o1.Fun1();
//		o1.Fun2(); // compiler could not find fun2
		
		// Case 2
		System.out.println("-----------Part2-----------------------");
		C o2 = new C();
		
		System.out.println(o2.d);
		System.out.println(o2.d1);
		System.out.println(o2.d2); // compiler could not find d2
		
		o2.Fun();
		o2.Fun1();
		o2.Fun2(); // compiler could not find fun2
		
		// Case 3
		System.out.println("-----------Part3-----------------------");
		P o3 = new C();
		
		System.out.println(o3.d);
		System.out.println(o3.d1);
//		System.out.println(o3.d2); // compiler could not find d2
		System.out.println(((C)o3).d2);
		
		o3.Fun();
		o3.Fun1();
//		o3.Fun2(); // compiler could not find fun2
		((C)o3).Fun2();
		
		// Case 3
		System.out.println("-----------Part4-----------------------");
//		C o4 = new P(); // not allowed to prevent runtime issues
	}

}
