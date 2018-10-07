package june21;

public class A5Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHighestFrequencyChar("abracadabra"));
	}

	public static char getHighestFrequencyChar(String str) {
		int[] arr = new int[256];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			arr[ch]++;
		}

		int max = arr[0];
		int maxidx = 0;

		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > max){
				max = arr[i];
				maxidx = i;
			}
		}
		
		return (char)maxidx;
	}

}
