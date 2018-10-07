import java.util.Scanner;

public class Square_Star_Pattern {

	public static void main(String[] args) {
	
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter No Of Row's");
		int n=scn.nextInt();
		for(int row=1;row<=n;row++){
			for(int cst=1;cst<=n;cst++){
				System.out.print("*");
				
			}
			System.out.println();
		}
		
		
		
		

	}

}
