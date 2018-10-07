package DynamicProgramming.BasicProblem;

public class Q49_Perfect_Sum_Problem {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		perfectSum(arr, 0, 10, "");
	}

	public static void perfectSum(int[] arr, int vidx, int num, String ans) {
		if (vidx == arr.length) {
			if (num == 0) {
				System.out.println(ans.substring(1));
			}
			return;
		}

		perfectSum(arr, vidx + 1, num, ans);
		perfectSum(arr, vidx + 1, num - arr[vidx], ans + " " + arr[vidx]);

	}
	
	

}
