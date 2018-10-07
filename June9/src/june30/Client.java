package june30;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
//		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		// printTargetSets(arr, 0, 120, "", 0);
		// printTargetSets(arr, 0, 100, new ArrayList<>(), 0);
//		printEquiSets(arr, 0, new ArrayList<>(), 0, new ArrayList<>(), 0);
//		printPermutations("abc", "");
		printPermutations2(new StringBuilder("abc"), new StringBuilder());
	}

	public static void printTargetSets(int[] arr, int vidx, int tar, String set, int sos) {
		if (vidx == arr.length) {
			if (sos < tar) {
				System.out.println(set);
			}
			return;
		}

		printTargetSets(arr, vidx + 1, tar, set, sos); // arr[vidx] says no
		printTargetSets(arr, vidx + 1, tar, set + " " + arr[vidx], sos + arr[vidx]);
	}

	public static void printTargetSets(int[] arr, int vidx, int tar, ArrayList<Integer> set, int sos) {
		if (vidx == arr.length) {
			if (sos < tar) {
				System.out.println(set);
			}
			return;
		}

		printTargetSets(arr, vidx + 1, tar, set, sos); // no

		set.add(arr[vidx]);
		printTargetSets(arr, vidx + 1, tar, set, sos + arr[vidx]);
		set.remove(set.size() - 1);
	}

	public static void printEquiSets(int[] arr, int vidx, String set1, int sos1, String set2, int sos2) {
		if (vidx == arr.length) {
			if (sos1 == sos2) {
				System.out.println(set1 + " and " + set2);
			}
			return;
		}

		printEquiSets(arr, vidx + 1, set1 + " " + arr[vidx], sos1 + arr[vidx], set2, sos2);
		printEquiSets(arr, vidx + 1, set1, sos1, set2 + " " + arr[vidx], sos2 + arr[vidx]);
	}

	public static void printEquiSets(int[] arr, int vidx, ArrayList<Integer> set1, int sos1, ArrayList<Integer> set2,
			int sos2) {
		if (vidx == arr.length) {
			if (sos1 == sos2) {
				System.out.println(set1 + " and " + set2);
			}
			return;
		}

		set1.add(arr[vidx]);
		printEquiSets(arr, vidx + 1, set1, sos1 + arr[vidx], set2, sos2);
		set1.remove(set1.size() - 1);

		set2.add(arr[vidx]);
		printEquiSets(arr, vidx + 1, set1, sos1, set2, sos2 + arr[vidx]);
		set2.remove(set2.size() - 1);
	}

	public static void printPermutations(String ques, String ans) {
		if(ques.length() == 0){
			System.out.println(ans);
			return;
		}
		
		for(int i = 0; i < ques.length(); i++){
			char ch = ques.charAt(i);
			String left = ques.substring(0,  i);
			String right = ques.substring(i + 1);
			String roq = left + right;
			
			printPermutations(roq, ans + ch);
		}
	}

	public static void printPermutations(StringBuilder ques, StringBuilder ans) {
		if(ques.length() == 0){
			System.out.println(ans);
			return;
		}
		
		for(int i = 0; i < ques.length(); i++){
			char ch = ques.charAt(i);
			ques.deleteCharAt(i);
			ans.append(ch);
			
			printPermutations(ques, ans);
			
			ans.deleteCharAt(ans.length() - 1);
			ques.insert(i, ch);
		}
	}
	
	public static void printPermutations2(StringBuilder ques, StringBuilder ans) {
		if(ques.length() == 0){
			System.out.println(ans);
			return;
		}
		
		char ch = ques.charAt(0);
		ques.deleteCharAt(0);
		
		for(int i = 0; i <= ans.length(); i++){
			ans.insert(i, ch);
			printPermutations2(ques, ans);
			ans.deleteCharAt(i);
		}
		
		ques.insert(0, ch);
	}
}
