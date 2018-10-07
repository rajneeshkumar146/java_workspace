import java.util.Scanner;

public class Absolute_Power_Of_2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// Number input
		int N = scn.nextInt();
		System.out.println(IsPowerOf2(N));
	}

	private static boolean IsPowerOf2(int n) {
		if (n == 0)
			return false;
		// check whether the number is power of two or not
		while (n != 1)// agar one last me aya,sirf tabhi ye power of two
						// hai,therwise nahi.
		{
			// jab tak one naa aaye
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}


}
