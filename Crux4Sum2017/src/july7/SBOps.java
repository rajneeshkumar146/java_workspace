package july7;

public class SBOps {

	public static void main(String[] args) {
		System.out.println(Q1("abDEfg"));
		System.out.println(Q2("bdrtl"));
		System.out.println(Q3("fca"));
		System.out.println(Q9("aaabbaaacccc"));
		Q8("abbbbasdljalksdj");
	}

	public static String Q1(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			char nch = ' ';

			if (ch >= 'a' && ch <= 'z') {
				nch = (char) (ch - 'a' + 'A');
			} else if (ch >= 'A' && ch <= 'Z') {
				nch = (char) (ch - 'A' + 'a');
			}

			sb.append(nch);
		}

		return sb.toString();
	}

	public static String Q2(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			char nch = ' ';

			if (i % 2 == 0) {
				nch = (char) (ch - 1);
			} else {
				nch = (char) (ch + 1);
			}

			sb.append(nch);
		}

		return sb.toString();
	}

	public static String Q3(String str) {
		StringBuilder sb = new StringBuilder();

		sb.append(str.charAt(0));
		char prev = str.charAt(0);

		for (int i = 1; i < str.length(); i++) {
			char curr = str.charAt(i);

			int diff = curr - prev;
			sb.append(diff);
			sb.append(curr);

			prev = curr;
		}

		return sb.toString();
	}

	public static String Q10(String str) {
		StringBuilder sb = new StringBuilder();
		char prev = str.charAt(0);
		int count = 1;

		for (int i = 1; i < str.length(); i++) {
			char curr = str.charAt(i);

			if (prev == curr) {
				count++;
			} else {
				sb.append(prev);
				if (count > 1) {
					sb.append(count);
				}
				
				count = 1;
			}

			prev = curr;
		}
		
		sb.append(prev);
		if (count > 1) {
			sb.append(count);
		}

		return sb.toString();
	}

	public static String Q9(String str) {
		StringBuilder sb = new StringBuilder();
		char prev = str.charAt(0);

		for (int i = 1; i < str.length(); i++) {
			char curr = str.charAt(i);

			if (prev == curr) {
			} else {
				sb.append(prev);
			}

			prev = curr;
		}
		
		sb.append(prev);

		return sb.toString();
	}

	public static void  Q8(String str) {
		int[] arr = new int[256];
		
		for(int i = 0; i < str.length(); i++){
			arr[str.charAt(i)]++;
		}
		
		int maxf = 0;
		char max = ' ';
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > maxf){
				maxf = arr[i];
				max = (char)i;
			}
		}
		
		System.out.println(max);
	}
}
