import java.util.Scanner;

public class Inverted_Triangle_Pattern01 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter number of row's");
		int n=scn.nextInt();
		for(int row=1;row<=n;row++){
            for(int csp=1;csp<=n;csp++){
            	if(row > csp){
            		System.out.print(" ");
            	}
            	else{
            		System.out.print("*");
            	}
            }
			System.out.println();
		}

	}

}

