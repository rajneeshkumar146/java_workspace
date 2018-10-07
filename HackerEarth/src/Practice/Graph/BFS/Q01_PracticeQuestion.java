package Practice.Graph.BFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class Q01_PracticeQuestion {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();
	private static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

	public static void main(String[] args) throws Exception {
		int n = scn.scanInt();
		while (n-- > 1) {
			int vtx1 = scn.scanInt();
			int vtx2 = scn.scanInt();
			if (!graph.containsKey(vtx1)) {
				graph.put(vtx1, new HashSet<>());
			}
			if(!graph.containsKey(vtx2)){
				graph.put(vtx2,new HashSet<>());
			}
			graph.get(vtx1).add(vtx2);
			graph.get(vtx2).add(vtx1);
		}
		int search = scn.scanInt();
		BFS(search-1);

	}

	public static void BFS(int search) {
		LinkedList<Integer> queue1 = new LinkedList<>();
		LinkedList<Integer> queue2 = new LinkedList<>();
		HashSet<Integer> isdone = new HashSet<>();

		queue1.addLast(1);

		while (!queue1.isEmpty()) {
			int value = queue1.removeFirst();
			isdone.add(value);
				ArrayList<Integer> vnames = new ArrayList<>(graph.get(value));
				for (Integer vname : vnames) {
					if (isdone.contains(vname)) {
						continue;
					}
					queue2.addLast(vname);
				}

				if (queue1.isEmpty() == true) {
					search--;
					if (search == 0) {
						System.out.println(queue2.size());
						return;
					}
					LinkedList<Integer> temp = queue1;
					queue1 = queue2;
					queue2 = temp;
				}

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
