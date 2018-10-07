package july6;

public class StringsDemo {

	public static void main(String[] args) {
		// Part 1
		String str;
		
		// Part 2
		str = "Hello";
		System.out.println(str.length());
		
		// Part 3
		System.out.println(str.charAt(0));
//		System.out.println(str.charAt(str.length()));
		System.out.println(str.charAt(str.length() - 1));
		
		// Part 4
		System.out.println(str.substring(2, 4)); // ll
		System.out.println(str.substring(2, 3)); // l
		System.out.println(str.substring(2, 2)); // ""
//		System.out.println(str.substring(2, 1));
		System.out.println(str.substring(2, 5)); // llo
//		System.out.println(str.substring(2, 6)); // out of bound
		System.out.println(str.substring(2)); // llo
		
		// Part 5
		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		
		// Part 6
		System.out.println(str.indexOf("el"));
		System.out.println(str.indexOf("eL"));
		
		// Part 7
		System.out.println(str.startsWith("He"));
		System.out.println(str.startsWith("he"));
		
		// Part 8
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		String s4 = new String("Hello");
		
		System.out.println((s1 == s2) + ", " + s1.equals(s2));
		System.out.println((s1 == s3) + ", " + s1.equals(s3));
		System.out.println((s1 == s4) + ", " + s1.equals(s4));
		
		loopsOnStrings(100000);
	}
	
	public static void loopsOnStrings(int n){
		long start = System.currentTimeMillis();
		
		String s = "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			s = s + i;
//			sb.append(i);
//			sb.insert(0, i);
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}

}
