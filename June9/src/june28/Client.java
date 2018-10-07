package june28;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		boolean[] boxes = new boolean[4];
//		 permutations(boxes, 2, 0, "");
		combinations(boxes, 2, 0, "", -1);
		System.out.println("---------------------------------");
		combinationsSS(boxes, 2, 0, 0, "");
		
//		Scanner scn = new Scanner(System.in);
//		char[][] box = new char[10][];
//		for(int i = 0; i < 10; i++){
//			box[i] = scn.nextLine().toCharArray();
//		}
//		String[] words = scn.nextLine().split(";");
//		
//		crossword(box, words, 0);
		
	}

	static int counter = 0;

	public static void permutations(boolean[] boxes, int tnq, int qpsf, String csf) {
		if (qpsf == tnq) {
			counter++;
			System.out.println(counter + ". " + csf);
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				permutations(boxes, tnq, qpsf + 1, csf + "[q" + qpsf + "b" + i + "] ");
				boxes[i] = false;
			}
		}

	}

	public static void combinations(boolean[] boxes, int tnq, int qpsf, String csf, int lqpb) {
		if (qpsf == tnq) {
			counter++;
			System.out.println(counter + ". " + csf);
			return;
		}

		for (int i = lqpb + 1; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				combinations(boxes, tnq, qpsf + 1, csf + "[q" + qpsf + "b" + i + "] ", i);
				boxes[i] = false;
			}
		}

	}

	public static void combinationsSS(boolean[] boxes, int tnq, int qpsf, int bno, String csf){
		if(qpsf == tnq){
			System.out.println(csf);
			return;
		}
		
		if(bno == boxes.length){
			return;
		}
		
		combinationsSS(boxes, tnq, qpsf, bno + 1, csf); // box refused to let a queen in
		if(boxes[bno] == false){
			boxes[bno] = true;
			combinationsSS(boxes, tnq, qpsf + 1, bno + 1, csf + "q" + qpsf + "b" + bno);
			boxes[bno] = false;
		}
	}
	
	/*
	 * +-++++++++ +-++++++++ +-++++++++ +-----++++ +-+++-++++ +-+++-++++
	 * +++++-++++ ++------++ +++++-++++ +++++-++++ DELHI;ICELAND;ANKARA;LONDON
	 */
	private static void crossword(char[][] box, String[] words, int widx) {
		if (widx == words.length) {
			for(int r = 0; r < box.length; r++){
				for(int c = 0; c < box.length; c++){
					System.out.print(box[r][c]);
				}
				System.out.println();
			}
			
			return;
		}
		
		String word = words[widx];

		for (int r = 0; r < box.length; r++) {
			for (int c = 0; c < box.length; c++) {
				if (box[r][c] == '-' || box[r][c] == word.charAt(0)) {
					// vertical placement
					if (canPlaceTheWordVertically(box, word, r, c)) {
						boolean[] reset = placeTheWordVertically(box, word, r, c);
						crossword(box, words, widx + 1);
						unplaceTheWordVertically(box, r, c, reset);
					}

					if (canPlaceTheWordHorizontally(box, word, r, c)) {
						boolean[] reset = placeTheWordHorizontally(box, word, r, c);
						crossword(box, words, widx + 1);
						unplaceTheWordHorizontally(box, r, c, reset);
					}
				}
			}
		}
	}

	private static boolean canPlaceTheWordVertically(char[][] box, String word, int r, int c) {
		for (int i = 0; i < word.length(); i++) {
			if (r + i >= box.length) {
				return false;
			} else if (box[r + i][c] != '-' && box[r + i][c] != word.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	private static boolean canPlaceTheWordHorizontally(char[][] box, String word, int r, int c) {
		for (int i = 0; i < word.length(); i++) {
			if (c + i >= box[0].length) {
				return false;
			} else if (box[r][c + i] != '-' && box[r][c + i] != word.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	private static boolean[] placeTheWordVertically(char[][] box, String word, int r, int c) {
		boolean[] reset = new boolean[word.length()];

		for (int i = 0; i < word.length(); i++) {
			if (box[r + i][c] == '-') {
				box[r + i][c] = word.charAt(i);
				reset[i] = true;
			}
		}

		return reset;
	}

	private static boolean[] placeTheWordHorizontally(char[][] box, String word, int r, int c) {
		boolean[] reset = new boolean[word.length()];

		for (int i = 0; i < word.length(); i++) {
			if (box[r][c + i] == '-') {
				box[r][c + i] = word.charAt(i);
				reset[i] = true;
			}
		}

		return reset;
	}

	private static void unplaceTheWordVertically(char[][] box, int r, int c, boolean[] reset) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i] == true) {
				box[r + i][c] = '-';
			}
		}
	}

	private static void unplaceTheWordHorizontally(char[][] box, int r, int c, boolean[] reset) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i] == true) {
				box[r][c + i] = '-';
			}
		}
	}

}
