package Peer;

import java.io.*;
import java.util.*;

public class Girls_and_Security_Patrol_PATROL {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			long u = scan.nextInt();
			long v = scan.nextInt();
			long d = scan.nextInt();
			double ans = (double) d / ((double) u + v);
			System.out.printf("%.10f", ans);
			System.out.println();
			--t;
		}
	}
}
