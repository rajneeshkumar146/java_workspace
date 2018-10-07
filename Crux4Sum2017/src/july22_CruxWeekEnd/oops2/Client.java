package july22_CruxWeekEnd.oops2;

public class Client {

	public static void main(String[] args) {
		// case 1
		P o1 = new P();
		
		System.out.println(o1.d);
		System.out.println(o1.d1);
//		System.out.println(o1.d2); compiler
		
		o1.Fun();
		o1.Fun1();
//		o1.Fun2(); compiler
		
		// case 2
		C o2 = new C();
		
		System.out.println(o2.d); // only case when jvm consults reference
		System.out.println(o2.d1);
		System.out.println(o2.d2); 
		
		o2.Fun();
		o2.Fun1();
		o2.Fun2(); 
		
		// case 3
		P o3 = new C();
		
		System.out.println(o3.d); // only case when jvm consults reference
		System.out.println(o3.d1);
//		System.out.println(o3.d2); compiler
		System.out.println(((C)o3).d2);
		System.out.println(((C)o3).d);
		
		o3.Fun();
		o3.Fun1();
//		o3.Fun2(); compiler
		((C)o3).Fun2();
		
		// case 3
//		C o4 = new P(); -> would have caused runtime errors if this was allowed 
				
	}

}
