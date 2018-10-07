package june24;

public class A4Q14 {

	public static void main(String[] args) {
//		int[] one = {9, 9, 9, 9};
//		int[] two = {8, 9, 9, 9, 9};
//		
//		int[] sum = sum(one, two);
//		for(int i = 0; i < sum.length; i++){
//			if(i == 0 && sum[i] == 0){
//				continue;
//			}
//			System.out.print(sum[i] + "\t");
//		}
		System.out.println(highestFreq("mississippi"));
	}
	
	public static int[] sum(int[] one, int[] two){
		int[] result = new int[one.length > two.length? one.length + 1: two.length + 1];
		
		int i = one.length - 1, j = two.length - 1, k = result.length - 1;
		int carry = 0;
		
		while(k >= 0){
			int sum = carry;
			
			if(i >= 0){
				sum = sum + one[i];
			}
			
			if(j >= 0){
				sum = sum + two[j];
			}
			
			result[k] = sum % 10;
			carry = sum / 10;
			
			i--;
			j--;
			k--;
		}
		
		return result;
	}

	// A5Q8
	public static char highestFreq(String str){
		int[] arr = new int[26];
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			arr[ch - 'a']++;
		}
		
		int mf = arr[0], mfi = 0;
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > mf){
				mf = arr[i];
				mfi = i;
			}
		}
		
		return (char)(mfi + 'a');
	}
}
