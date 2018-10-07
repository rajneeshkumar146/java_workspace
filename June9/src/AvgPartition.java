
public class AvgPartition {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 15, 29, 11, 9 };

		int sum = 0;
		for (int val : arr) {
			sum += val;
		}

		int avg = sum / arr.length;

		boolean[][][] strg = new boolean[arr.length / 2 + 1][arr.length + 1][avg * arr.length / 2 + 1];

		// for count = 1
		strg[1][0][0] = true;
		for (int i = 1; i <= arr.length; i++) {
			strg[1][i][0] = true;
			for (int sigma = 1; sigma <= avg * arr.length / 2; sigma++) {
				strg[1][i][sigma] = strg[1][i - 1][sigma];
				if (sigma - arr[i - 1] >= 0) {
					strg[1][i][sigma] |= strg[1][i - 1][sigma - arr[i - 1]];
				}
			}
		}

		for (int count = 2; count <= arr.length / 2; count++) {
			for (int i = 1; i <= arr.length; i++) {
				for (int sigma = 1; sigma <= avg * arr.length / 2; sigma++) {
					strg[count][i][sigma] = strg[count][i - 1][sigma];
					if (sigma - arr[i - 1] >= 0) {
						strg[count][i][sigma] |= strg[count - 1][i - 1][sigma - arr[i - 1]];
					}
				}
			}
		}
		
		for (int count = 1; count <= arr.length / 2; count++) {
			for (int i = 1; i <= arr.length; i++) {
				for (int sigma = 1; sigma <= avg * arr.length / 2; sigma++) {
					System.out.print(strg[count][i][sigma] ? 1: 0);
				}
				System.out.println();
			}
			System.out.println("--------------------------------------------");
		}
		
		System.out.println(strg[arr.length / 2][arr.length][avg * arr.length / 2]);
	}

}
