package Class_3rd_Binary_Invrerse_Rotation;

import java.util.Scanner;

public class Inverse {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Please Enter Your number");
		int n=scn.nextInt();
		int len=0;
		int	temp_n=n,nn=0;
		for(len=0;temp_n!=0;len++){
			temp_n=temp_n / 10;
		}
		System.out.println("length of number is:"+len);
		int place=1;
		for(int num=1;num<=len;num++){
			int rem=n%10;
			n=n/10;
			nn=nn + place*(int)Math.pow(10,rem-1);
			place++;
		}
		System.out.println("Your New Number is;"+nn);
		
	}

}
