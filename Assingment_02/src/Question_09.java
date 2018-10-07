import java.util.Scanner;

public class Question_09 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Number of Row's");
		int n = scn.nextInt();
		/* n^C(k+1) = (n^Ck * (n-k))/(k+1) Formula Used 2nd term relatiobn with
		1st term and in n^Ck total (n+1)term so n should be equal to row and
	    row start from 0 and here k represent column it also start from 0.*/
		
		int k=0,val=1;  // here val=1 is equivalet to first elemnt 0^C0=1
		if(n>0 && n<100){
			for(int row=0;row<n;row++){
				val=1;
		    for(k=0;k<=row;k++){
				System.out.print(val+" ");
				val=(val*(row-k))/(k+1);
		    }
				System.out.println();
			}
		}
		
	}

}
