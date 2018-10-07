import java.util.Scanner;

public class Hollow_Diamond_Pattern_Type1 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter number of row's ");
		int n=scn.nextInt();
		int nst=n/2+1, nsp=1;
		for(int row=1;row<=n;row++){
			for(int crt=1;crt<=nst;crt++){
				System.out.print("*");
			}
			for(int csp=1;csp<=nsp;csp++){
				System.out.print(" ");
			}
			for(int crt=1;crt<=nst;crt++){
				System.out.print("*");
			}
			if(row<=n/2){
			nst--;
			nsp+=2;
			}
			else{
				nst++;
				nsp-=2;
			}
			
			System.out.println();
		}

	}

}
