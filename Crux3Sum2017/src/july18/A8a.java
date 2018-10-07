package july18;

import java.util.ArrayList;

public class A8a {

	public static void main(String[] args) {
		// toh(3, "A", "B", "C");
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		System.out.println(getEquiGroups(arr, 0, "", "", 0, 0));
	}

	public static void toh(int n, String begin, String end, String help) {
		if (n == 0) {
			return;
		}

		toh(n - 1, begin, help, end);
		System.out.println(n + "th from " + begin + " to " + end);
		toh(n - 1, help, end, begin);
	}

	public static ArrayList<String> getEquiGroups(int[] arr, int vidx, String g1, String g2, int sg1, int sg2) {
		if (vidx == arr.length) {
			ArrayList<String> br = new ArrayList<>();

			if (sg1 == sg2) {
				br.add(g1 + " and " + g2 + "\n");
			}

			return br;
		}

		ArrayList<String> rrg1 = getEquiGroups(arr, vidx + 1, g1 + " " + arr[vidx], g2, sg1 + arr[vidx], sg2);
		ArrayList<String> rrg2 = getEquiGroups(arr, vidx + 1, g1, g2 + " " + arr[vidx], sg1, sg2 + arr[vidx]);
		ArrayList<String> mr = new ArrayList<>();
		mr.addAll(rrg1);
		mr.addAll(rrg2);

		return mr;
	}
}
