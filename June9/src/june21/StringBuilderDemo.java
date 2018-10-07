package june21;

public class StringBuilderDemo {

	public static void main(String[] args) {
		// StringBuilder sb = new StringBuilder("hello");
		// System.out.println(sb.length()); // size
		//
		// char ch = sb.charAt(0); // get
		// System.out.println(ch);
		//
		// sb.setCharAt(2, 't'); // set
		// System.out.println(sb);
		//
		// sb.deleteCharAt(2); // delete
		// System.out.println(sb);
		//
		// sb.insert(2, 'z'); // insert
		// System.out.println(sb);
		//
		// sb.append('y');
		// System.out.println(sb);
		//
		// String s = sb.toString(); // SB to String
		// System.out.println(s);
		//
		// StringBuilder sb1 = new StringBuilder(s);

		String s = "aaabbbccdaafffgg";
		// s = toggleCase(s);
		// System.out.println(s);
//		s = modify2(s);
		s = compress2(s);
		System.out.println(s);
	}

	public static String toggleCase(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);

			if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch - 'A' + 'a');
			} else if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - 'a' + 'A');
			}

			sb.setCharAt(i, ch);
		}

		return sb.toString();
	}

	// odd pos -> reduce asci by 1
	// even pos -> increase asci by 1
	// bcdef -> cbedg
	public static String modify1(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);

			if (i % 2 == 0) {
				ch = (char) (ch + 1);
			} else {
				ch = (char) (ch - 1);
			}

			sb.setCharAt(i, ch);
		}

		return sb.toString();
	}

	// between two char, add the difference of their ascii
	// adbgj -> a3d-2b5g3j
	public static String modify2(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length() - 1; i++){
			char ch = str.charAt(i);
			char chp1 = str.charAt(i + 1);
			int diff = chp1 - ch;
			
			sb.append(ch);
			sb.append(diff);
		}
		
		sb.append(str.charAt(str.length() - 1));

		return sb.toString();
	}

	public static String compress1(String str){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length() - 1; i++){
			char ch = str.charAt(i);
			char chn = str.charAt(i + 1);
			
			if(ch != chn){
				sb.append(ch);
			}
		}
		
		sb.append(str.charAt(str.length() - 1));
		
		return sb.toString();
	}
	
	public static String compress2(String str){
		StringBuilder sb = new StringBuilder();
		
		int counter = 1;
		for(int i = 0; i < str.length() - 1; i++){
			char ch = str.charAt(i);
			char chn = str.charAt(i + 1);
			
			if(ch != chn){
				sb.append(ch);
				if(counter > 1){
					sb.append(counter);
				}
				counter = 1;
			} else {
				counter++;
			}
		}
		
		sb.append(str.charAt(str.length() - 1));
		if(counter > 1){
			sb.append(counter);
		}
		
		return sb.toString();
	}
}
