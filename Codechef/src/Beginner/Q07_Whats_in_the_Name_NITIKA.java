package Beginner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Q07_Whats_in_the_Name_NITIKA {
	private static Scanner scn = new Scanner(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		int T = scn.nextInt();
		scn.nextLine();
		while (T-- > 1) {
			solve();
			pnter.printLine("");
		}
		solve();
		pnter.close();
	}

	public static void solve() throws Exception {

		String str = scn.nextLine();
		ArrayList<String> al = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == ' ') {
				al.add(sb.toString());
				sb = new StringBuilder();
				continue;
			}
			sb.append(ch);
		}
		al.add(sb.toString());

		int size = al.size();
		sb = new StringBuilder();

		for (int i = 0; i < al.size(); i++) {
			str = al.get(i);

			if (size == 3) {
				sb.append(str.substring(0, 1).toUpperCase() + ". ");
				size--;
			} else if (size == 2) {
				sb.append(str.substring(0, 1).toUpperCase() + ". ");
				size--;
			}

			else if (size == 1) {
				for (int j = 0; j < str.length(); j++) {
					char ch = str.charAt(j);
					if (j != 0) {
						ch |= ' '; // lowerCase Coversion.
						sb.append(ch);
					} else {
						ch &= '_';// UpperCase Coversion.
						sb.append(ch);
					}
				}

				size--;
			}
		}

		pnter.print(sb.toString());
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
