package june15;

public class DataTypesDemo {

	public static void main(String[] args) {
		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;
		
//		lo = in;
//		lo = sh;
//		lo = by;
//		
//		in = lo;
//		in = sh;
//		in = by;
//		
//		sh = lo;
//		sh = in;
//		sh = by;
		
		by = 10;
		by = 127;
//		by = 128;
		by = (byte)400;
		System.out.println(by);
		
		in = (int)10000000000L;
		lo = 10000000000L;
		System.out.println(lo);
		
	}

}
