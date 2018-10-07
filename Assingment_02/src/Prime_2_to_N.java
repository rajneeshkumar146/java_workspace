import java.util.Scanner;

public class Prime_2_to_N {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Number between 2 to n");
		int n = scn.nextInt();
		if (n > 2) {
			for (int row = 2; row <= 3; row++) {
				System.out.println(row);
			}
			for (int row = 4; row <= n; row++) {
				int check = 0;
				for (int temp = 2; temp <= (row - 1); temp++) {
					if (row % temp == 0) {
						check = 1;
					}
					
				}
				if (check == 0) {
					System.out.println(row);
				}

			}

		}
	}

}
