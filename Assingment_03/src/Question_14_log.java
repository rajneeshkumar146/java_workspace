import java.util.Scanner;

public class Question_14_log {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Your logrithm Number");
		int n = scn.nextInt();
		
		System.out.println("Enter Your logrithm Base");
		int b = scn.nextInt();
		
		int temp=1;
		for(int i=1;true;i++){
			temp=temp*b;
			if(temp==n){
				System.out.println(i);
				return;
			}
			
		}

	}

}
