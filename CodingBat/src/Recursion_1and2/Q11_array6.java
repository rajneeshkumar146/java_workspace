package Recursion_1and2;

import java.util.Scanner;

public class Q11_array6 {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	     while(in.hasNext()){ 
		 String s=in.nextLine();
		 if(s.contentEquals("end-of-file.")){
		 System.out.println(s);
		 in.close();
		 }else{
			 System.out.println(s);
			
		 }
	     }
	      
	      
}

	public static boolean array6(int[] nums, int index) {
		if (index == nums.length) {
			return false;
		}

		if (nums[index] == 6) {
			return true;
		}
		return array6(nums, index + 1);
	}

}
