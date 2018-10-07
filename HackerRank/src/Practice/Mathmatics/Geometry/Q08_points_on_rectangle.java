package Practice.Mathmatics.Geometry;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q08_points_on_rectangle {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		int T = scn.scanInt();
		while (T-- > 1) {
			pnter.printLine(solve() ? "YES" : "NO" + "");
		}
		pnter.print(solve() ? "YES" : "NO" + "");
		pnter.close();
	}

	public static boolean solve() throws Exception {
		int q = scn.scanInt();
		int[] x = new int[q];
		int[] y = new int[q];

		int xmin = 100000;
		int xmax = -100000;
		int ymin = 100000;
		int ymax = -100000;

		for (int i = 0; i < q; i++) {
			x[i] = scn.scanInt();

			if (x[i] < xmin) {
				xmin = x[i];
			}
			if (x[i] > xmax) {
				xmax = x[i];
			}

			y[i] = scn.scanInt();
			if (y[i] < ymin) {
				ymin = y[i];
			}
			if (y[i] > ymax) {
				ymax = y[i];
			}

		}

//		 pnter.print(xmin + " " + xmax + " " + ymin + " " + ymax);
		boolean flag = true;
		for (int i = 0; i < q; i++) {
			int x0 = x[i];
			int y0 = y[i];
			if (x0 < xmin || x0 > xmax || y0 < ymin || y0 > ymax) {
				flag = false;
			} else if ((x0 == xmin || x0 == xmax) || (y0 == ymin || y0 == ymax)) {
				if (flag != false)
					flag = true;
			} else {
				flag = false;
			}
		}

		return flag;

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
