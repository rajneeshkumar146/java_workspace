import java.util.Scanner;

public class Question_13 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's");
		System.out.println();
		int n = scn.nextInt();
		int nsp = n-1, nst = 1, val = 0;
		if(n>0){
		for(int row=1;row<=n;row++){
			for(int csp=1;csp<=nsp;csp++){
				System.out.print(" ");
			}
			
			val=row;
			
			for(int cst=1;cst<=nst;cst++){
				System.out.print(val);
				if(cst<=nst/2){
					val++; 
				}else{
					val--;
				}
			}
			nst+=2;
			nsp--;
			
			System.out.println();
		}
		}else{
			System.out.println("Please enter number of row's between 1 to 5");
		}
	}

}
