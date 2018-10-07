package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Q04_Minimum_possible_number_in_one_swap {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Entre Your Number");
		int x = scn.nextInt();
		System.out.println(MinNumber(x));

	}

	private static int[] arrayForming(int x) {
		int len = 1;
		int temp = x;
		while (temp / 10 != 0) {
			temp = temp / 10;
			len++;
		}
		int[] arr = new int[len];
		arr[len - 1] = x % 10;
		len -= 2;
		while (x / 10 != 0) {
			x = x / 10;
			arr[len] = x % 10;
			len--;
		}

		return arr;
	}

	public static int MinNumber(int x) {
		int[] tarr = arrayForming(x);
		int[] arr = tarr.clone();
		Arrays.sort(tarr);
		boolean flag = false;
		int i = 0;
		int j = 0;

		int tnum = 0;
		if (tarr[0] == 0) {
			if (arr[0] == tarr[1]) {
				tnum = tarr[0];
				j++;
				flag = true;
			} else if (arr[0] != tarr[1] && tarr[1] != 0) {
				i++;
				tnum = tarr[i];
				flag = true;
			}
		}

		if (flag == false) {
			i++;
			j++;
			while (i < arr.length) {
				if (tarr[i] == arr[j]) {
					i++;
					j++;
				} else {
					break;
				}
			}

			tnum = tarr[i];
		}

		arr = actualarray(j, tnum, arr);
		return actualnum(arr);

	}

	private static int actualnum(int[] arr) {
		int rv = arr[0];

		for (int i = 1; i < arr.length; i++) {
			rv = rv * 10 + arr[i];
		}

		return rv;
	}

	private static int[] actualarray(int j, int tnum, int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] == tnum) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		return arr;

	}

}
