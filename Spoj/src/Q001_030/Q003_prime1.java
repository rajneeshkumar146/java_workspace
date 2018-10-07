package Q001_030;

import java.util.Scanner;

public class Q003_prime1 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int t = scn.nextInt();
		while (t-- > 0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			primePrint(x,y);
			System.out.println();
		}

	}

	private static void primePrint(int i,int j) {
     while(i<=j){
    	 if(i==1){
    		 i++;
    		 continue;
    	 }
    	 boolean flag=false;
    	 for(int k=2;k*k<=i;k++){
    		 if(i%k==0){
    			 flag=true;
    			 break;
    		 }
    	 }
    	 
    	 if(!flag){
    		 System.out.println(i);
    	 }
    	 i++;
     }
		
		
		
	}

}
