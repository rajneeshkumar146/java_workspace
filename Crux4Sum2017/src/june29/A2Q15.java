package june29;

public class A2Q15 {

	public static void main(String[] args) {
		int n = 5;

		int row = 1;
		int sppr = 2 * n - 3, csp = 1;
		int stpr = 1, cst = 1;

		int val = 1;
		while (row <= n) {
			val = 1;

			// stars
			cst = 1;
			while (cst <= stpr) {
				System.out.print(val);
				val++;
				cst++;
			}

			// spaces
			csp = 1;
			while (csp <= sppr) {
				System.out.print(" ");
				csp++;
			}

			// stars
			if (row == n) {
				cst = 2;
				val = val - 2;
			} else {
				cst = 1;
				val = val - 1;
			}

			while (cst <= stpr) {
				System.out.print(val);
				val--;
				cst++;
			}

			stpr++;
			sppr = sppr - 2;

			System.out.println();
			row++;
		}
	}

}
