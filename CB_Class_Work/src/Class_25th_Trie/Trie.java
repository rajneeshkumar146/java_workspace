package Class_25th_Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	private class Node {
		private Character data;
		private boolean eow;
		HashMap<Character, Node> children = new HashMap<>();
	}

	private Node root = new Node();
	private int numWords = 0;
	private int numNodes = 1; // 1 due to root.

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			node.eow = true;
			this.numWords++;
			return;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = node.children.get(ch);

		if (child == null) {
			child = new Node();
			this.numNodes++;
			child.data = ch;
			node.children.put(ch, child);
			addWord(child, ros);
		} else {
			addWord(child, ros);
		}

	}

	public boolean searchWord(String word) {

		return searchWord(root, word);

	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = node.children.get(ch);

		if (child == null) {
			return false;
		} else {
			return searchWord(child, ros);
		}

	}

	public void removeWord(String word) {
		removeWord(root, word);
	}

	private void removeWord(Node node, String word) {
		if (word.length() == 0) {
			this.numWords--;
			node.eow = false;
			return;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = node.children.get(ch);

		if (child == null) {
			return;
		} else {
			removeWord(child, ros);

			if (child.eow == false && child.children.size() == 0) {
				this.numNodes--;
				node.children.remove(ch);
			}

		}

	}

	public void dispaly() {
		display(root, "");
	}

	private void display(Node node, String osf) {
		if (node.eow) {
			System.out.print(osf + " ");
		}

		ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
		for (Character key : keys) {
			Node child = node.children.get(key);
			display(child, osf + key);

		}

	}

}
