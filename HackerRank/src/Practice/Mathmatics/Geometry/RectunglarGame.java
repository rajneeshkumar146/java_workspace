package Practice.Mathmatics.Geometry;

import java.util.Scanner;

public class RectunglarGame {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long minrow = scn.nextLong();
		long mincol = scn.nextLong();
		int i = 1;
		while (i < n) {
			long newMinr = scn.nextLong();
			if (newMinr < minrow)
				minrow = newMinr;
			long newMinc = scn.nextLong();
			if (newMinc < mincol)
				mincol = newMinc;
			i++;
		}
		long ans=0;
		ans = minrow * mincol;
		System.out.println(ans);
		scn.close();
	}
}
