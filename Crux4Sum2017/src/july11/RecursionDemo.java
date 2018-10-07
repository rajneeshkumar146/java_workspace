package july11;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long st = System.currentTimeMillis();
		// System.out.println(Fib(70));
		// System.out.println(System.currentTimeMillis() - st);

		// printTriangle(1, 1, 5);
		// int[] arr = {11, 55, 22, 44, 33};
		// bubbleSort(arr, 0, arr.length - 1);
		// july10.RecursionDemos.display(arr, 0);
//		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
//		int[] two = { 1, 1, 1, 2, 2, 4, 5 };
//
//		ArrayList<Integer> inter = getIntersection(one, two);
//		System.out.println(inter);
//		System.out.println(getPermutations("abc"));
		
		System.out.println(getSS("abcd"));
	}

	// public static long startTime(){
	// return
	// }
	//
	public static int Fib(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);
		int rv = fnm1 + fnm2;
		
		return rv;
	}

	public static void printRows(int r, int n) {
		if (r > n) {
			return;
		}

		System.out.println("hello");
		printRows(r + 1, n);
	}

	public static void printCols(int c, int n) {
		if (c > n) {
			return;
		}

		System.out.print("*");
		printCols(c + 1, n);
	}

	public static void printBox(int r, int c, int n) {
		if (r > n) {
			return;
		}

		if (c > n) {
			System.out.println();
			printBox(r + 1, 1, n);
			return;
		}

		System.out.print("*");
		printBox(r, c + 1, n);
	}

	public static void printTriangle(int r, int c, int n) {
		if (r > n) {
			return;
		}

		if (c > r) {
			System.out.println();
			printTriangle(r + 1, 1, n);

			return;
		}

		System.out.print("*");
		printTriangle(r, c + 1, n);

	}

	public static void bubbleSort(int[] arr, int si, int ei) {
		if (ei == 0) {
			return;
		}

		if (si == ei) {
			bubbleSort(arr, 0, ei - 1);
			return;
		}

		if (arr[si] > arr[si + 1]) {
			july4.ArraysCtd.Swap(arr, si, si + 1);
		}

		bubbleSort(arr, si + 1, ei);
	}

	public static ArrayList<Integer> getIntersection(int[] one, int[] two) {
		ArrayList<Integer> inter = new ArrayList<>();

		int i = 0, j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] == two[j]) {
				inter.add(one[i]);
				i++;
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			}
		}

		return inter;
	}
	
	public static ArrayList<String> getSS(String str){
		if(str.length() == 0){
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();
		
		for(String rs: rr){
			mr.add(rs);
			mr.add(ch + rs);
			mr.add((int)ch + rs);
		}
		
		return mr;
	}

	public static ArrayList<String> getPermutations(String str){
		if(str.length() == 0){
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rr = getPermutations(ros);
		ArrayList<String> mr = new ArrayList<>();
		
		for(String rs: rr){
			for(int i = 0; i <= rs.length(); i++){
				StringBuilder sb = new StringBuilder(rs);
				sb.insert(i, ch);
				mr.add(sb.toString());
			}
		}
		
		return mr;
	}

}
