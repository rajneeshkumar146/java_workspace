package june29;

public class D2B {

	public static void main(String[] args) {
		int dec = 39;
		int bin = 0;
		
		int pow = 1; // 10 ^ 0;
		while(dec != 0){
			int rem = dec % 2;
			
			bin = bin + rem * pow;
			
			dec = dec / 2;
			pow = pow * 10;
		}
		
		System.out.println(bin);
	}

}
