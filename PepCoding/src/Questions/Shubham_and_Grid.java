package Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Shubham_and_Grid {
	public static InputStreamReader r = new InputStreamReader(System.in);
	public static BufferedReader br = new BufferedReader(r);
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

	}

	public static void solve() throws Exception {

	}

	public static boolean isQuad(int[][] arr, int sr, int sc, boolean[][] isdone) {
		if (isdone[sr][sc]) {
			return false;
		}

		isdone[sr][sc] = true;
	
		
		
		
		return false;

	}

	public static boolean isAnEdge(int[][] arr, int sr, int sc, int er, int ec) {

		if (sr < 1 || sc >= arr.length || er < 1 || ec >= arr.length) {
			return false;
		}

		if (arr[sr][sc] + 1 == arr[er][ec]) {
			return true;
		}

		return false;

	}
}
