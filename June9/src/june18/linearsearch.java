package june18;

import java.util.Scanner;

public class linearsearch {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.takeInput();
		ArrayUtils.display(arr);
		
		Scanner scn = new Scanner(System.in);
		System.out.println("What do you want to find?");
		int data = scn.nextInt();
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == data){
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}

}
