import java.util.Scanner;

public class Mirrored_Triangle_Pattern01 {

	public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter number of row's");
			int n = scn.nextInt();
			for(int row=1;row<=n;row++){
				for(int csp=1;csp<=n;csp++){
					if(csp<=n-row){
						System.out.print(" ");
					}else{
						System.out.print("*");
				}
				
				
				
			}
				System.out.println();

		}


	}

}
