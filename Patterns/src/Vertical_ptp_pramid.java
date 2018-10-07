import java.util.Scanner;

public class Vertical_ptp_pramid {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		verticalPTPperamid(n);
	}
	
	public static void verticalPTPperamid(int n){ // vertical_Point_to_point_pramid
		
		int nsp=0;
		int nst=n;
		for(int row=1;row<=2*n-1;row++){
			for(int csp=1;csp<=nsp;csp++){
				System.out.print(" ");
			}
			
			for(int cst=1;cst<=2*nst-1;cst++){
				if(cst%2!=0){
				System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			if(row<n){
			nsp++;
			nst--;
			}else if(row==n){
				nsp--;
				nst=2;
			}else{
				nsp--;
				nst++;
			}
		
			System.out.println();
		}
		
		
	}

}
