import java.util.Scanner;

public class Question_07 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's between 1 to 5");
		System.out.println();
		int n = scn.nextInt();
		int val=1;
		for(int row=1;row<=n;row++){
			for(int cst=1;cst<=row;cst++){
				System.out.print(val);
				val++;
			}
			
			System.out.println();
		}
	}

}
