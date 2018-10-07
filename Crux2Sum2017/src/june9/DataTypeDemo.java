package june9;

import java.math.BigInteger;

public class DataTypeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Part 1
		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;
				
//		by = sh;
//		by = in;
//		by = lo;
				
		sh = by;
//				sh = in;
//				sh = lo;
				
		in = by;
		in = sh;
//				in = lo;
				
		lo = by;
		lo = sh;
		lo = in;
		
		// Part 2
		by = 10;
		by = 127;
//		by = 128;
		by = (byte)256;
		System.out.println(by);
		
		// Part 3
		in = 1000000000;
		in = (int)10000000000L;
		
		// Part 4
//		float fl = 5.5;
		double db = 5.5;
		float fl = 5.5f;
		
//		fl = db;
		db = fl;
		
		// Part 5
//		in = fl;
		in = (int)fl;
		fl = in;
		
		// Part 6
		boolean bl = true;
		bl = false;
//				bl = 0;
//				bl = 1;
				
//				if(in){
//					System.out.println("hi");
//				}
//				else {
//					System.out.println("bye");
//				}
				
		if(in > 0){
			System.out.println("hi");
		}
		else {
			System.out.println("bye");
		}
		
		if(bl){
			System.out.println("hi");
		}
		else {
			System.out.println("bye");
		}
		
		
		// Part 7
		char ch = 'a';
		ch = 97;
		ch = (char)70000;
		
		in = ch;
//		ch = in;
		ch = (char)in;
		
		in = ch + 2;
//		ch = ch + 2;
		ch = 'a';
		ch = (char)(ch + 2);
		System.out.println(ch);
		
		
		// Part 8
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");
		
		
		
		
		
		
	}

}
