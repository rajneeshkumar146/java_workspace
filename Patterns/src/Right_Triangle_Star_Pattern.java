import java.util.Scanner;

public class Right_Triangle_Star_Pattern {

	public static void main(String[] args) {
	
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n=scn.nextInt();
		for(int row=1;row<=n;row++){
			for(int crt=1;crt<=row;crt++){
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
