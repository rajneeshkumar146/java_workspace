import java.util.Scanner;

public class Rombus_Star_Pattern {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n=scn.nextInt();
		int nsp=0;
		for(int row=1;row<=n;row++){
			for(int csp=1;csp<=nsp;csp++){
				System.out.print(" ");
			}
			for(int cst=1;cst<=6;cst++){
				System.out.print("*");
			}
			nsp++;
			
			System.out.println();
		}
	}

}
