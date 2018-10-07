package Geometry;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class Convexal {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	private static point start;

	private static class point {
		private int x;
		private int y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}

	}

	public static int getOrientation(point p1, point p2, point p3) {

		// (y2-y1)(x3-x1) - (y3-y1)(x2-x1) > 0___For_Clockwise.
		// (y2-y1)(x3-x1) - (y3-y1)(x2-x1) < 0___For_AntiClockwise.
		// (y2-y1)(x3-x1) - (y3-y1)(x2-x1) = 0___For_Collinear.

		int res = (p2.y - p1.y) * (p3.x - p1.x) - (p3.y - p1.y) * (p2.x - p1.x);

		return res == 0 ? 0 : res > 0 ? 1 : -1;
	}

	private static boolean IntersectionLine(point p1, point p2, point p3, point p4) {

		int dir1 = getOrientation(p1, p2, p3);
		int dir2 = getOrientation(p1, p2, p4);
		int dir3 = getOrientation(p3, p4, p1);
		int dir4 = getOrientation(p3, p4, p2);

		if ((dir1 != dir2) && (dir3 != dir4)) {
			return true;
		}

		if (dir1 == 0 && OnSegment(p1, p2, p3)) {
			return true;
		} else if (dir2 == 0 && OnSegment(p1, p2, p4)) {
			return true;
		} else if (dir3 == 0 && OnSegment(p3, p4, p1)) {
			return true;
		} else if (dir4 == 0 && OnSegment(p3, p4, p2)) {
			return true;
		}

		return false;
	}

	private static boolean OnSegment(point p1, point p2, point p3) {

		int minx = Math.min(p1.x, p2.x);
		int maxx = Math.max(p1.x, p2.x);
		int miny = Math.min(p1.y, p2.y);
		int maxy = Math.max(p1.y, p2.y);

		return p3.x > minx && p3.x < maxx && p3.y > miny && p3.y < maxy;

	}

	private static ArrayList<point> convexHullJarvis(point[] arr, int n) {
		ArrayList<point> hull = new ArrayList<point>();

		int minxIndex = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].x < arr[minxIndex].x) {
				minxIndex = i;
			}
		}

		int prev = minxIndex;
		int curr = -1;
		while (minxIndex != curr) {
			hull.add(arr[prev]);
			curr = (prev + 1) % n;

			for (int i = 0; i < n; i++) {
				if (getOrientation(arr[prev], arr[curr], arr[i]) < 0) { // ClockWise_Suitable_edge_dekhrhe_hai.
					curr = i;
				}
			}

			prev = curr;
		}

		return hull;
	}

	private static int distance(point p1, point p2) {
		int deltaY = p2.y - p1.y;
		int deltaX = p2.x - p1.x;

		return deltaY * deltaY + deltaX * deltaX;
	}

	private static class pointscomparator implements Comparator<point> {

		@Override
		public int compare(point p1, point p2) {

			int orientation = getOrientation(start, p1, p2);
			if (orientation == 0) {
				int startToP1Distance = distance(start, p1);
				int startToP2Distance = distance(start, p2);
				return startToP1Distance - startToP2Distance;
			} else {
				return orientation;
			}
		}

	}

	private static LinkedList<point> convexHullGrahmScan(point[] arr, int n) {

		LinkedList<point> HullStack = new LinkedList<point>(); // AddFirst_and_RemoveFirst.

		int BMi = 0;
		for (int i = 1; i < n; i++) {

			if (arr[i].y < arr[BMi].y) {
				BMi = i;
			} else if (arr[i].y == arr[BMi].y) {
				if (arr[i].x < arr[BMi].x) {
					BMi = i;
				}
			}
		}

		start = arr[BMi];

		// Arrays.sort(arr, new pointscomparator());

		Arrays.sort(arr, (p1, p2) -> {
			int orientation = getOrientation(start, p1, p2);
			if (orientation == 0) {
				int startToP1Distance = distance(start, p1);
				int startToP2Distance = distance(start, p2);
				return startToP1Distance - startToP2Distance;
			} else {
				return orientation;
			}

		});

		HullStack.addFirst(arr[0]);
		HullStack.addFirst(arr[1]);

		for (int i = 2; i < n; i++) {
			point p1 = HullStack.removeFirst();
			point p2 = arr[i];

			while (getOrientation(HullStack.getFirst(), p1, p2) > 0) { // AntiClockWise_Check_krna_hai.
				p1 = HullStack.removeFirst();
			}

			HullStack.addFirst(p1);
			HullStack.addFirst(p2);
		}

		return HullStack;
	}

	public static void main(String[] args) throws Exception {

		point[] points = new point[10];
		points[0] = new point(0, 15);
		points[1] = new point(10, 0);
		points[2] = new point(3, -1);
		points[3] = new point(8, -8);
		points[4] = new point(-1, -1);
		points[5] = new point(3, 0);
		points[6] = new point(-8, -10);
		points[7] = new point(4, 2);
		points[8] = new point(0, 8);
		points[9] = new point(-9, 0);

		// System.out.println(convexHullJarvis(points, points.length));

		System.out.println(convexHullGrahmScan(points, points.length));

		pnter.close();
	}

	// -------------------------------------------------------------------------------------------------------------

	private static int NumberLength(int n) {
		int length = 0;
		while (n != 0) {
			length++;
			n = n / 10;
		}

		return length;
	}

	private static void ReverseArray(int[] arr, int st, int en) {
		for (int i = st; st <= en; st++, en--) {
			swap(arr, st, en);
		}
	}

	private static int[] PrifixSumArray(int le, int ri, int[] arr) {
		for (int i = le + 1; i < ri; i++) {
			arr[i] += arr[i - 1];
		}

		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void Swap2DEle(int[][] arr, int i1, int j1, int i2, int j2) {
		int temp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = temp;
	}

	private static int maxInArray(int[] arr) {
		int max = arr[0];
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}

		return max;
	}

	private static int[] takeArrayInput(int n) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
			// arr[i] = scn.nextInt();
		}
		return arr;
	}

	private static int[][] takeMatrixInput(int n, int m) throws IOException {
		int[][] arr = new int[n][m];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				arr[row][col] = scn.scanInt();
				// arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}

	private static void displayArray(int le, int ri, int[] arr) throws IOException {
		for (int i = le; i <= ri; i++) {
			pnter.print(arr[i] + " ");
			// System.out.print(arr[i]+" ");
		}
		pnter.printLine("");
		// System.out.println();
	}

	private static void displayMatrix(int[][] arr) throws IOException {
		for (int[] i : arr) {
			for (int el : i) {
				pnter.print(el + " ");
				// System.out.print(el+" ");
			}
			pnter.printLine("");
			// System.out.println();
		}
	}

	private static void cloneArray(int[] arr, int[] Oarr, int n) {
		for (int i = 0; i < n; i++) {
			arr[i] = Oarr[i];
		}

	}

	static class Scan {
		private InputStream in;
		private byte[] buf = new byte[1024 * 1024];
		private int index;
		private int total;

		public Scan(InputStream in) {
			this.in = in;
		}

		public int scan() throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int scanInt() throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public long scanLong() throws IOException {
			long integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public double scanDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}

		public String scanString() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	static class Print {
		private final BufferedWriter bw;

		public Print() {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(String str) throws IOException {
			bw.append(str);
		}

		public void printLine(String str) throws IOException {
			print(str);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
}
