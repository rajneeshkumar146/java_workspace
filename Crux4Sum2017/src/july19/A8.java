package july19;

import java.util.ArrayList;

public class A8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toh(3, "A", "B", "C", 0));
		// int[] arr = {10, 20, 30, 40, 50, 60, 70};
		// split(arr, 0, "", "", 0, 0);
		// System.out.println(getSubset(arr, 0, 70));
	}

	public static int toh(int n, String begin, String end, String aux, int count) {
		if (n == 0) {
			return count;
		}

		count = toh(n - 1, begin, aux, end, count);
		System.out.println("Move " + n + "th disc from " + begin + " to " + end);
		count++;
		count = toh(n - 1, aux, end, begin, count);

		return count;
	}

	public static void split(int[] arr, int vidx, String grp1, String grp2, int sg1, int sg2) {
		if (vidx == arr.length) {
			if (sg1 == sg2) {
				System.out.println(grp1 + " and " + grp2);
			}
			return;
		}

		split(arr, vidx + 1, grp1 + " " + arr[vidx], grp2, sg1 + arr[vidx], sg2);
		split(arr, vidx + 1, grp1, grp2 + " " + arr[vidx], sg1, sg2 + arr[vidx]);
	}

	public static ArrayList<ArrayList<Integer>> getSubset(int[] arr, int vidx, int tar) {
		if (vidx == arr.length - 1) {
			ArrayList<ArrayList<Integer>> br = new ArrayList<>();

			if (tar == 0) {
				ArrayList<Integer> thebasess = new ArrayList<>();
				br.add(thebasess);
			} else if (tar == arr[vidx]) {
				ArrayList<Integer> thebasess = new ArrayList<>();
				thebasess.add(arr[vidx]);
				br.add(thebasess);
			}

			return br;
		}

		ArrayList<ArrayList<Integer>> mr = new ArrayList<>();

		ArrayList<ArrayList<Integer>> rrNo = getSubset(arr, vidx + 1, tar);
		ArrayList<ArrayList<Integer>> rrYes = getSubset(arr, vidx + 1, tar - arr[vidx]);

		for (ArrayList<Integer> noss : rrNo) {
			mr.add(noss);
		}

		for (ArrayList<Integer> yesss : rrYes) {
			yesss.add(arr[vidx]);
			mr.add(yesss);
		}

		return mr;
	}
}
