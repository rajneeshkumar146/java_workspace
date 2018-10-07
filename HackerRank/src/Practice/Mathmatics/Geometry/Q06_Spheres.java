package Practice.Mathmatics.Geometry;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q06_Spheres {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		long T = scn.scanLong();
		while (T-- > 1) {
			pnter.printLine(solve() ? "YES" : "NO" + "");
		}
		pnter.print(solve() ? "YES" : "NO" + "");
		pnter.close();

	}

	public static boolean solve() throws Exception {
		long R1 = scn.scanLong();
		long R2 = scn.scanLong();

		long x1 = scn.scanLong();
		long y1 = scn.scanLong();
		long z1 = scn.scanLong();

		long ax1 = scn.scanLong();
		long ay1 = scn.scanLong();
		long az1 = scn.scanLong();

		long x2 = scn.scanLong();
		long y2 = scn.scanLong();
		long z2 = scn.scanLong();

		long ax2 = scn.scanLong();
		long ay2 = scn.scanLong();
		long az2 = scn.scanLong();

		return Calculation(R1 + R2, x2 - x1, y2 - y1, z2 - z1, ax2 - ax1, ay2 - ay1, az2 - az1);

	}

	private static boolean Calculation(long r, long x0, long y0, long z0, long a0, long b0, long c0) throws IOException {

		long a = a0 * a0 + b0 * b0 + c0 * c0;// acceleration_Square
		long b = x0 * a0 + y0 * b0 + z0 * c0;// distance_Product_Acceleration
		long c = x0 * x0 + y0 * y0 + z0 * z0; // initial_distance_Square

		/*
		 * x(t) = x0 + 1/2 * a0 * t^2, y(t) = y0 + 1/2 * b0 * t^2, z(t) = z0 +
		 * 1/2 * c0 * t^2,
		 * 
		 * D^2 = x(t)^2 + y(t)^2 z(t)^2
		 * 
		 * x(t)=distanceX-r, y(t)=distanceX-r, z(t)=distanceX-r
		 * 
		 * for touching distanceX = distanceY = distanceZ=0
		 * 
		 * General Equation: at^4 + bt^2 +c=x(t)
		 * 
		 * c=c-r*r;
		 * 
		 * a=1/4(A);
		 * 
		 */

		c -= r * r;

		long Discriminant = b * b - a * c;

//		pnter.printLine(a + ", " + b + ", " + c);

		if (Discriminant < 0) {
			return false;
		} else if (c <= 0) { // alpha.Beta = c/a. so_oppsite_Sign_Root.
			return true;
		} else if (b < 0) { // alpha + Beta = -b/a. Both_Root_are_Positive.
			return true;
		} else { // Both_roots_are_negative.
			return false;
		}

	}

	// -----------------------------------------------------------------------------------------

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
