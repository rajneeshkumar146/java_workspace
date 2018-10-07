package june15;

public class SetTheBit {

	public static void main(String[] args) {
		int n = 57;
		int k = 2;

		System.out.println(n + " = " + Integer.toBinaryString(n));
		
		int mask = 1 << k;
		System.out.println(mask + " = " + Integer.toBinaryString(mask));
		
		int test = n | mask;
		System.out.println(test + " = " + Integer.toBinaryString(test));
	}

}
