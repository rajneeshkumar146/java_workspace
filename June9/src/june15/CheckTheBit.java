package june15;

public class CheckTheBit {

	public static void main(String[] args) {
		int n = 57;
		int k = 3;

		System.out.println(n + " = " + Integer.toBinaryString(n));
		
		int mask = 1 << k;
		System.out.println(mask + " = " + Integer.toBinaryString(mask));
		
		int test = n & mask;
		System.out.println(test + " = " + Integer.toBinaryString(test));
		
		if (test == mask) {
			System.out.println("bit is on");
		} else {
			System.out.println("bit is off");
		}
	}

}
