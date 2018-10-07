package DynamicProgramming.BasicProblem;

public class Q43_Friends_Pairing_Problem {

	public static void main(String[] args) {
		int ans = frndPairing(10);
		System.out.println(ans);
	}

	public static int frndPairing(int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}

		int single = frndPairing(n - 1);
		int pair = (n - 1) * frndPairing(n - 2);

		return single + pair;

	}

}
