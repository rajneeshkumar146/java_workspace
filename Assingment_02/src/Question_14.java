import java.util.Scanner;

public class Question_14 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n = scn.nextInt();
		int nsp = n / 2, nst = 1, val = 1;
		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			if(row<=n/2+1){
				val=row;
			}else{
				val=(n+1)-row;
			}
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				if(cst<=nst/2){
					val++;
				}else{
					val--;
				}

			}
			if (row <= n / 2) {
				nst += 2;
				nsp--;
			} else {
				nst -= 2;
				nsp++;
			}

			System.out.println();
		}

	}

}
