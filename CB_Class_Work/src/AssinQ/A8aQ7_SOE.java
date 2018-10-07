package AssinQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class A8aQ7_SOE {

	public static void main(String[] args) {

		HashMap<Integer, Integer> ladder = new HashMap<>();
		boolean[] arr = soe(15);
//		for(int i=0;i<arr.length;i++){
//			if(arr[i]==false){
//				System.out.println(i);
//			}
//		}
		

		int left = 0;
		int right = arr.length-1;
		while (left < right) {
			while (arr[left] != true) {
				left++;
			}

			while (arr[right] != true) {
				right--;
			}

			if (left < right) {
				ladder.put(left, right);
			}
			left++;
			right--;
			
		}
		
		ladderquestion(0, 15, "", ladder);

	}

	public static boolean[] soe(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int tbl = 2; tbl * tbl <= n; tbl++) {

			if (prime[tbl] == false) {
				continue;
			}
			for (int ja = 2; tbl * ja <= n; ja++) {
				prime[ja * tbl] = false;
			}

		}

		return prime;
	}

	public static void ladderquestion(int curr, int end, String asf, HashMap<Integer, Integer> ladder) {
		if (end == curr) {
			System.out.println(asf);
			return;
		}

		if (end < curr) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			if (ladder.containsKey(curr)) {
				ladderquestion(ladder.get(curr), end, asf + "[L" + curr + "=>" + ladder.containsKey(curr) + "]",
						ladder);
			} else {
				ladderquestion(curr + dice, end, asf + "[" + dice + "]", ladder);
			}
		}

	}

}
