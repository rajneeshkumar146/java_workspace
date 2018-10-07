package Practice.Algorithms.Search;

import java.util.Scanner;

public class Q001_SherlockAndArray {
	public static Scanner scn = new Scanner(System.in);

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int T = in.nextInt();
	        for(int a0 = 0; a0 < T; a0++){
	            int n = in.nextInt();
	            int[] a = new int[n];
	            for(int a_i=0; a_i < n; a_i++){
	                a[a_i] = in.nextInt();
	            }
	            String result = SherlockAndArray(a);
	            System.out.println(result);
	        }
	    }
	    
	    private static String SherlockAndArray(int[] arr){
	        int[] suffixSum=suffixSum(arr);
	        int[] preffixSum=preffixSum(arr);
	        
	        for(int i=0;i<arr.length;i++){
	            if(suffixSum[i]==preffixSum[i]){
	                return "YES";
	            }
	        }
	        
	        return "NO";
	    }
	    
	    private static int[] suffixSum(int[] arr){
	        int[] sum=new int[arr.length];
	       sum[0]=arr[0];
	        for(int i=1;i<arr.length;i++){
	         sum[i]+=arr[i]+sum[i-1];   
	        }
	        return sum;
	    }
	    
	    
	    private static int[] preffixSum(int[] arr){
	        int[] sum=new int[arr.length];
	       sum[arr.length-1]=arr[arr.length-1];
	        for(int i=arr.length-2;i>=0;i--){
	         sum[i]+=arr[i]+sum[i+1];   
	        }
	        
	        return sum;
	    }
	
	
}
