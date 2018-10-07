package Class_11th_recursion_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Printtarget_variation_subset {
	public static void main(String[] args) {
		int[] arr = {10, 20,30, 40, 50, 60, 70};
//		int[] arr={1,3,5,6,8,10,11,13,15,17,18,19,21};
		// int[] arr = { 10, 20, 30 };

		// printtarget_subset(arr, 0, 70, "");
		// System.out.println(targetsubset(arr, 0, 70, ""));

		// print_sgtt_subset(arr, 0, 30, "");

//		print_split_mendentory_array(arr, 0, 0, 0, "", "");

		// print_split_notmendentory_array(arr, 0, 0, 0, "", "");
//		print_split_notconsecuative_array(arr, 0, 0, 0, "", "", false, false);

		 print_split_notconsecuative_array2(arr, 0, 0, 0, "", "", 0, 0);
	}

	public static void printtarget_subset(int[] arr, int vidx, int target, String asf) { // asf=Answer_so_far
		if (vidx == arr.length) {
			if (target == 0) {
				System.out.println(asf);
			}
			return;
		}

		printtarget_subset(arr, vidx + 1, target, asf); // no
		printtarget_subset(arr, vidx + 1, target - arr[vidx], asf + arr[vidx] + " "); // yes

	}

	public static ArrayList<String> targetsubset(int[] arr, int vidx, int target, String asf) {
		if (vidx == arr.length) {
			ArrayList<String> br = new ArrayList<>();
			if (target == 0) {
				br.add(asf);
			}
			return br;
		}

		ArrayList<String> rr = targetsubset(arr, vidx + 1, target, asf);
		ArrayList<String> rrs = targetsubset(arr, vidx + 1, target - arr[vidx], asf + arr[vidx] + " ");
		ArrayList<String> mr = new ArrayList<>();
		mr.addAll(rr);
		mr.addAll(rrs);
		return mr;

	}

	public static void print_sgtt_subset(int[] arr, int vidx, int target, String asf) { // asf=Answer_so_far,sgtt=sum_greater_than_target
		if (vidx == arr.length) {
			if (target < 0) {
				System.out.println(asf);
			}
			return;
		}

		print_sgtt_subset(arr, vidx + 1, target, asf); // no
		print_sgtt_subset(arr, vidx + 1, target - arr[vidx], asf + "\t" + arr[vidx]); // yes

	}

	public static void print_split_mendentory_array(int[] arr, int vidx, int sg1, int sg2, String g1, String g2) {
		if (vidx == arr.length) {
			if (sg1 == sg2) {
				System.out.printf("%-15s %s %n", g1, g2);
			}
			return;
		}

		print_split_mendentory_array(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2);

		print_split_mendentory_array(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx]);

	}

	public static void print_split_notmendentory_array(int[] arr, int vidx, int sg1, int sg2, String g1, String g2) {
		if (vidx == arr.length) {
			if (sg1 == sg2) {
				System.out.println(g1 + " and" + g2);
			}
			return;
		}
		print_split_notmendentory_array(arr, vidx + 1, sg1, sg2, g1, g2);

		print_split_notmendentory_array(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2);

		print_split_notmendentory_array(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx]);

	}

	public static void print_split_notconsecuative_array(int[] arr, int vidx, int sg1, int sg2, String g1, String g2,
			boolean ig1, boolean ig2) {

		if (vidx == arr.length) {
			if (sg1 == sg2) {
				System.out.println(g1 + "and" + g2);
			}
			return;
		}
		if (ig1 == false && ig2 == false) {
			print_split_notconsecuative_array(arr, vidx + 1, sg1, sg2, g1, g2, false, false);

			print_split_notconsecuative_array(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2, true,
					false);

			print_split_notconsecuative_array(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx], false,
					true);
		} else if (ig1 == false) {
			print_split_notconsecuative_array(arr, vidx + 1, sg1, sg2, g1, g2, false, false);

			print_split_notconsecuative_array(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2, true,
					false);

		} else if (ig2 == false) {
			print_split_notconsecuative_array(arr, vidx + 1, sg1, sg2, g1, g2, false, false);

			print_split_notconsecuative_array(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx], false,
					true);
		}

	}
	
	public static void print_split_notconsecuative_array2(int[] arr, int vidx, int sg1, int sg2, String g1, String g2,
			int ig1, int ig2) {

		if (vidx == arr.length) {
			if (sg1 == sg2) {
				System.out.println(g1 + "and" + g2);
			}
			return;
		}

		print_split_notconsecuative_array2(arr, vidx + 1, sg1, sg2, g1, g2, ig1, ig2);

		if (arr[vidx] - ig1 != 20) {
			print_split_notconsecuative_array2(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2, arr[vidx],
					ig2);
		}

		if (arr[vidx] - ig2 != 20) {
			print_split_notconsecuative_array2(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx], ig1,
					arr[vidx]);
		}
	}

}
