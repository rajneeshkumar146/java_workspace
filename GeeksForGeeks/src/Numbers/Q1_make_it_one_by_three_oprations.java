package Numbers;

import java.util.Scanner;

public class Q1_make_it_one_by_three_oprations {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Entre Number: ");
		int n = scn.nextInt();
		 System.out.println(operations(n));
		 System.out.println(wrongMethod(n));
	}

	public static int operations(int n) {

		if (n == 1) {
			return 0;
		}

		int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z = Integer.MAX_VALUE;

		if (n % 2 == 0) {
			y = operations(n / 2);
		}
		if (n % 3 == 0) {
			z = operations(n / 3);
		}
		x = operations(n - 1);
		return Math.min(x, Math.min(y, z)) + 1;
	}

	public static int wrongMethod(int n){  //Greedy_Approach_(Doesn’t_work_always)_:_for_10_it_gives_4_but_ans_is_3.
		int count=0;
		
		while (n!=1) {
			if (n % 3 == 0) {
				n = n / 3;
				count++;
			} else if (n % 2 == 0) {
				n = n / 2;
				count++;
			} else {
				n = n - 1;
				count++;
			} 
		}
		
		return count;
	}

}
