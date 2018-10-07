import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int n = scn.nextInt();
		
		int row = 1;
		int nst = 1, nsp = n - 1;
		int val = 1;
		
		while(row <= 2 * n - 1){
			int csp = 1;
			while(csp <= nsp){
				System.out.print(" ");
				csp++;
			}
			
			if(row <= n){
				val = row;
			} else {
				val = 2 * n - row;
			}
			
			int cst = 1;
			while(cst <= nst){
				System.out.print(val);
				if(cst <= nst / 2){
					val++;
				} else {
					val--;
				}
				
				cst++;
			}
			
			if(row < n){
				nst += 2;
				nsp--;
			} else {
				nst -= 2;
				nsp++;
			}
			
			row = row + 1;
			System.out.println();
		}
	}

}
