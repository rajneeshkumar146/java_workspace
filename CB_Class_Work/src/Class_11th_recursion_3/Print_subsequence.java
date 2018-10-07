package Class_11th_recursion_3;

public class Print_subsequence {

	public static void main(String[] args) {
		char[] arr = { 'a', 'b', 'c' };
//		print_subsequence(arr, 0, "");
		print_sub("abcabc", "");
	}

	public static void print_subsequence(char[] arr, int vidx, String asf) { // asf=Answer_so_far
		if (vidx == arr.length) {
			System.out.println(asf);
			return;
		}

		print_subsequence(arr, vidx + 1, asf); // no
		print_subsequence(arr, vidx + 1, asf + arr[vidx]); // yes

	}

	public static void print_sub(String que, String ans) {
		if (que.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = que.charAt(0);
		String roq = que.substring(1);

		print_sub(roq, ans);
		print_sub(roq, ans + ch);
		

	}

}
