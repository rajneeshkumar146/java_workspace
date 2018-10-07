package june15;

public class TurnBitOff {

	public static void main(String[] args) {
		int n = 57;
		int k = 3;

		System.out.println(n + " = " + Integer.toBinaryString(n));
		
		int mask = 1 << k;
		System.out.println(mask + " = " + Integer.toBinaryString(mask));
		
		int revmask = ~mask;
		System.out.println(revmask + " = " + Integer.toBinaryString(revmask));
		
		int test = n & revmask;
		System.out.println(test + " = " + Integer.toBinaryString(test));
	}

}
