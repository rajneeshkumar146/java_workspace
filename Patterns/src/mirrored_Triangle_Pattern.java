import java.util.Scanner;

public class mirrored_Triangle_Pattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n = scn.nextInt();
		for(int row=1;row<=n;row++){
			for(int csp=1;csp<=n-row;csp++){
				System.out.print(" ");
			}
			for(int cst=1;cst<=row;cst++){
				System.out.print("*");
			}
			
			System.out.println();
			
		}

	}

}
