import java.util.Scanner;

public class Question_11 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n=scn.nextInt();
		int nsp=n/2,nst=1;
		for(int row=1;row<=n;row++){
			for(int csp=1;csp<=nsp;csp++){
				System.out.print(" ");
			}
			for(int cst=1;cst<=nst;cst++){
				System.out.print("*");
			}
			if(row<=n/2){
			nsp--;
			nst+=2;
			}
			else{
				nsp++;
				nst-=2;
			}
			System.out.println();
		}
	}
}
