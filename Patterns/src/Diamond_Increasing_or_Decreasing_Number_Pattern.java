import java.util.Scanner;

public class Diamond_Increasing_or_Decreasing_Number_Pattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n = scn.nextInt();
		numberPattern1(n);
		System.out.println();
		numberPattern2(n);
		
		
	
	}

	public static void numberPattern1(int n) {
		int nsp = n / 2, nst = 1, val = 1;
		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			if (row <= n / 2) {
				val = row;
			} else {
				val = n + 1 - row;

			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				if (cst <= nst / 2)
					val++;
				else
					val--;
			}
			if (row <= n / 2) {
				nsp--;
				nst += 2;
			} else {
				nsp++;
				nst -= 2;
			}
			System.out.println();
		}
	}

	public static void numberPattern2(int n) {
		int nsp = n / 2, nst = 1, val = 1;
		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			if (row <= n / 2) {
				val = row;
			} else {
				val = n + 1 - row;

			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				if (cst <= nst / 2)
					val--;
				else
					val++;
			}
			if (row <= n / 2) {
				nsp--;
				nst += 2;
			} else {
				nsp++;
				nst -= 2;
			}
			System.out.println();
		}
	}
}
