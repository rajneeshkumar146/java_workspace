package BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Q161_CrytoArithmaticPuzzle {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		CrytoArithmaticPuzzle();
	}

	private static String exp1;
	private static String exp2;
	private static String exp3;

	private static void CrytoArithmaticPuzzle() throws IOException {
		exp1 = scn.scanString();
		exp2 = scn.scanString();
		exp3 = scn.scanString();

		HashSet<Character> ques = new HashSet<>();
		populateQMap(ques, exp1);
		populateQMap(ques, exp2);
		populateQMap(ques, exp3);

		HashMap<Integer, Boolean> availNums = new HashMap<>();
		for (int i = 0; i <= 9; i++) {
			availNums.put(i, true);
		}

		HashMap<Character, Integer> ans = new HashMap<>();
		CrytoArithmaticPuzzleSolver(ques, ans, availNums);
	}

	private static void CrytoArithmaticPuzzleSolver(HashSet<Character> ques, HashMap<Character, Integer> ans,
			HashMap<Integer, Boolean> options) throws IOException {
		if (ques.size() == 0) {
			if (GetExp(exp1, ans) + GetExp(exp2, ans) == GetExp(exp3, ans)) {
				pnter.printLine(ans + "");
			}
			return;
		}

		char ch = ques.iterator().next();
		ques.remove(ch);

		for (int i = 0; i <= 9; i++) {
			if (!options.get(i)) {
				continue;
			}
			options.put(i, false);
			ans.put(ch, i);
			CrytoArithmaticPuzzleSolver(ques, ans, options);
			ans.remove(ch);
			options.put(i, true);
		}

		ques.add(ch);

	}

	private static int GetExp(String exp, HashMap<Character, Integer> ans) {
		int num = 0;
		int pow = 1;
		for (int i = 0; i < exp.length(); i++) {
			num += ans.get(exp.charAt(i)) * pow;
			pow *= 10;
		}
		return num;
	}

	private static void populateQMap(HashSet<Character> ques, String exp) {
		for (int i = 0; i < exp.length(); i++) {
			ques.add(exp.charAt(i));
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------

	private static class Scan {
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

		public String scanStringLine() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpaceModified(n))
				n = scan();
			while (!isWhiteSpaceModified(n)) {
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

		private boolean isWhiteSpaceModified(int n) {
			if (n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	private static class Print {
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
