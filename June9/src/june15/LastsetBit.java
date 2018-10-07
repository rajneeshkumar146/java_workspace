package june15;

public class LastsetBit {

	public static void main(String[] args) {
		int x = -128;
		int t = x & -x;
		
		System.out.println(x + " = " + Integer.toBinaryString(x));
		System.out.println(t + " = " + Integer.toBinaryString(t));
	}

}
