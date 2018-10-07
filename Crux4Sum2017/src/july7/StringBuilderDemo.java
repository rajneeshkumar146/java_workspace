package july7;

import java.util.Scanner;

public class StringBuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		Scanner sc = new Scanner(System.in) ;
//		String s = sc.nextLine() ;
		
//		StringBuilder sb = new StringBuilder("hello");
//		System.out.println(sb);
//
//		System.out.println(sb.length());
//		System.out.println(sb.capacity());
//		
//		System.out.println(sb.charAt(sb.length() - 1));
////		System.out.println(sb.charAt(sb.length()));
//		
//		// mutable
//		sb.setCharAt(3, 'p');
//		System.out.println(sb);
//		
//		sb.deleteCharAt(3);
//		System.out.println(sb);
//		
//		sb.append("bye");
//		System.out.println(sb);
//		
//		sb.insert(2, "abc");
//		System.out.println(sb);
		
		
//		String s1 = "hello";
//		String s2 = "hello";
//		String s3 = new String("hello");
//		StringBuilder sb = new StringBuilder("hello");
//		System.out.println();
//		
//		StringBuilder sb2 = sb;
//		StringBuilder sb3 = new StringBuilder("hello");
		
		StringBuilder sb = new StringBuilder("acdefg");
		sb.insert(2, "dell");
		System.out.println(sb.toString());
	}

}
