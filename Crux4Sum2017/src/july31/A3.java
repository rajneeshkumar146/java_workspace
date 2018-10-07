package july31;

import java.util.Scanner;

public class A3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(IsArmstrong(375));
//		PrintArmstrong(1, 10000);
//		PrintSeries(10, 5);
		Q19();
	}
	
	public static boolean IsArmstrong(int num){
		int nod = 0;
		int temp = num;
		
		while(temp != 0){
			temp /= 10;
			nod++;
		}
		
		int check = 0;
		temp = num;
		while(temp != 0){
			int rem = temp % 10;
			temp /= 10;
			
			check += (int)Math.pow(rem, nod);
		}
		
		return check == num;
	}
	
	public static void PrintArmstrong(int n1, int n2){
		for(int i = n1; i <= n2; i++){
			boolean armstrong = IsArmstrong(i);
			if(armstrong){
				System.out.println(i);
			}
		}
	}
	
	public static void PrintSeries(int n1, int n2){
		int count = 1, lc = 1;
		int num = 0;
		
		while(count <= n1){
			num = 3 * lc + 2;
			
			if(num % n2 != 0){
				System.out.println(num);
				count++;
			}
			lc++;
		}
	}

	public static void Q19(){
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Numbers?");
		int n = scn.nextInt();
		
		System.out.println("Enter the 1st number");
		int prev = scn.nextInt();
		int curr = 0;
		
		int counter = 2;
		boolean direction = true; // true means south
		while(counter <= n){
			System.out.println("Enter the " + counter + "th number");
			curr = scn.nextInt();
			
			// logic starts
			if(direction){
				if(curr < prev){
					// expected
				} else {
					direction = false;// false means north
				}
			} else {
				if(curr > prev){
					// expected
				} else {
					System.out.println("Invalid");
					return;
				}
			}
			
			// logic ends
			
			prev = curr;
			counter++;
		}
		
		System.out.println("Valid");
		
	}
}
