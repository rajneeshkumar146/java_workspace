import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t>0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            getMaxUjjuArr(arr);
            t--;
        }
    }
    
    public static void getMaxUjjuArr(int[] arr){
        int[] arr1 = new int[arr.length];
        arr1[0] = arr[0];
        for(int i=1; i<arr1.length; i++){
            arr1[i] = Math.max(arr1[i-1],arr[i]);
        }
        
        int[] arr2 = new int[arr.length];
        arr2[arr2.length-1] = arr[arr.length-1];
        for(int i=arr2.length-2; i>=0; i--){
            arr2[i] = Math.min(arr2[i+1],arr[i]);
        }
        
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr2[i]+" ");
        // }
        int i=0;
        int j=0;
        int max = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>=arr2[j]){
                j++;
                if(max<(j-i)){
                    max = j-i;
                }
            } else{
                i++;
            }
        }
        System.out.println(max);
    }
}