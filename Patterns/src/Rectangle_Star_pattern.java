import java.util.Scanner;

public class Rectangle_Star_pattern {

	public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter number of Row's");
	int x=scn.nextInt();
	System.out.println("Enter number of Column");
	int y=scn.nextInt();
	for(int row=1;row<=x;row++){
		for(int col=1;col<=y;col++)
		{
			System.out.print("*");
		}
		System.out.println();
	}

	}

}
