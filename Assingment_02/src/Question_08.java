import java.util.Scanner;

public class Question_08 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of row's");
		System.out.println();
		int n = scn.nextInt();
		int val = 1;
		for (int row = 1; row <= n; row++) {
			val=row;
			for (int cst = 1; cst <= row; cst++) {
				if(cst>1 && cst<row){
					System.out.print("0");
				}else{
				System.out.print(val);
				}
			}
			System.out.println();
		}

	}

}
