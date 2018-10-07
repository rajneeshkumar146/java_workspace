package DynamicProgramming.BasicProblem;

public class Q21_Count_number_of_ways_to_reach_a_given_score {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 10 };
		int num = 20;

		System.out.println("Ways are: " + countWays(num, " "));
		System.out.println("Ways are: " + countWaysBtr(arr, 0, num, ""));
		// System.out.println("Ways are: "+countWaysDP(num));

	}

	public static int countWays(int num, String ans) { // hrbr_number_increase_hi_hoga_like_333510._not_possible_3353.
		if (num == 0) {
			System.out.println(ans.substring(1));
			return 1;
		}

		if (num < 0) {
			return 0;
		}

		int count3 = 0, count5 = 0, count10 = 0;
		if (ans.charAt(ans.length() - 1) != '5' && ans.charAt(ans.length() - 1) != '0') { // iski_call_tabhi_lagegi_jb_phele_5_ya_10_ki_call_na_laggi_ho.
			count3 = countWays(num - 3, ans + "3");
		}
		if (ans.charAt(ans.length() - 1) != '0') {// iski_call_tabhi_lagegi_jb_phele_10_ki_call_na_laggi_ho.
			count5 = countWays(num - 5, ans + "5");
		}

		count10 = countWays(num - 10, ans + "10");

		return count3 + count5 + count10;
	}

	public static int countWaysBtr(int[] arr, int vidx, int num, String ans) {  //sochna_asaan_hai_pr_calls_zada_lagegi.
		if (num == 0) {
			System.out.println(ans);
			return 1;
		}

		if (num < 0) {
			return 0;
		}

		if (vidx == arr.length) {
			return 0;
		}
		int count = 0;

		count += countWaysBtr(arr, vidx, num - arr[vidx], ans + arr[vidx]);
		count += countWaysBtr(arr, vidx + 1, num, ans);

		return count;

	}

	public static int countWaysDP(int num) {

		int[] arr = new int[num + 1];
		arr[0] = 1;
		for (int i = 3; i <= num; i++) {
			arr[i] += arr[i - 3];
		}
		for (int i = 5; i <= num; i++) {
			arr[i] += arr[i - 5];
		}
		for (int i = 10; i <= num; i++) {
			arr[i] += arr[i - 10];
		}

		return arr[num];
	}

}
