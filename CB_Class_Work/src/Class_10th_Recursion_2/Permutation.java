package Class_10th_Recursion_2;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {

		String str = "abcdef";
		ArrayList<String> list = getpermutation(str);
		System.out.println(list);

	}

	public static ArrayList<String> getpermutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1); // ros=rest_of_string
		ArrayList<String> rr = getpermutation(ros); // rr=recursion_result
		ArrayList<String> result = new ArrayList<>(); // mr=my_result

		for (String rs : rr) {
			for (int i = 0; i <= rs.length(); i++) {
				result.add(rs.substring(0, i) + ch + rs.substring(i));
			}
		}

		return result;

	}

}
