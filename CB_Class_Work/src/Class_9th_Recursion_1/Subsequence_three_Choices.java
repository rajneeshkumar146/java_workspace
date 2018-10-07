package Class_9th_Recursion_1;

import java.util.ArrayList;

public class Subsequence_three_Choices {

	public static void main(String[] args) {
		
		ArrayList<String> inter = getsubsequence_three_Choices("abcd");
		System.out.println(inter);

	}

	public static ArrayList<String> getsubsequence_three_Choices(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

			char ch = str.charAt(0);
			String ros = str.substring(1); // ros=rest_of_string
			ArrayList<String> rr = getsubsequence_three_Choices(ros); // rr=recursion_result
			ArrayList<String> mr = new ArrayList<>(); // mr=my_result

			for (String rs : rr) {
				mr.add(rs);
				mr.add(ch + rs);
				mr.add((int)ch + rs);
				
			}

			return mr;
		}

	}
