package Assingment_08a_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q10_Smaller_than_given_String_in_dictionary_order {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter String from which you want bigger string according to dictionary order");
		String ques = scn.nextLine();
		
		stgsido_v(ques, "", ques.charAt(0));

		System.out.println(stgsido_r(ques, "", ques.charAt(0)));
		

	}

	public static void stgsido_v(String ques, String ans, char neg) { // Smaller_than_given_String_in_dictionary_order_void

		if (ques.length() == 0) {
			if (ans.charAt(0) < neg) {
				System.out.println(ans);
			}

			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			stgsido_v(roq, ans + ch, neg);

		}

	}

	public static ArrayList<String> stgsido_r(String ques, String ans, char neg) { // Smaller_than_given_String_in_dictionary_order_return

		if (ques.length() == 0) {
			ArrayList<String> recu_res = new ArrayList<>();
			if (ans.charAt(0) < neg) {
				recu_res.add(ans);
			}
			return recu_res;
		}
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			ArrayList<String> recu_res = stgsido_r(roq, ans + ch, neg);
			result.addAll(recu_res);
		}

		return result;

	}
}
