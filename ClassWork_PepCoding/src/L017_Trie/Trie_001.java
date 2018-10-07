package L017_Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Trie_001 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		Trie tr = new Trie();
		tr.addWord("and");
		tr.addWord("ant");
		tr.addWord("an");
		tr.addWord("are");
		tr.addWord("art");
		tr.addWord("as");
		tr.addWord("ak");

		// System.out.println(tr.SerachWord("an"));
		// tr.removeWords("an");
		// System.out.println(tr.SerachWord("an"));

		// tr.display();
		tr.displayTree();

	}

	// Trie.===================================================================================================

	private static class Trie {

		private static class Node {
			private char data;
			private HashMap<Character, Node> childrens = new HashMap<>();
			private boolean isWord;

			private Node(char data, boolean isword) {
				this.data = data;
				this.isWord = isword;

			}
		}

		private Node root = new Node('&', false);
		private int CountOfNodes;
		private int CountOfWords;

		public boolean SerachWord(String word) {
			return SearchWord(this.root, word);
		}

		private boolean SearchWord(Node node, String word) {
			if (word.length() == 0) {
				return node.isWord;
			}

			char ch = word.charAt(0);
			if (node.childrens.containsKey(ch)) {
				boolean res = SearchWord(node.childrens.get(ch), word.substring(1));
				if (res) {
					return true;
				}
			}
			return false;
		}

		public void addWord(String word) {
			if (!SearchWord(root, word)) {
				addWord(root, word);
			} else {
				return;
			}
		}

		private void addWord(Node node, String word) {
			if (word.length() == 0) {
				node.isWord = true;
				CountOfWords++;
				return;
			}

			char ch = word.charAt(0);
			if (node.childrens.containsKey(ch)) {
				addWord(node.childrens.get(ch), word.substring(1));
			} else {
				Node nnode = new Node(ch, false);
				CountOfNodes++;
				node.childrens.put(ch, nnode);
				addWord(nnode, word.substring(1));
			}

		}

		public void removeWords(String word) {
			if (SearchWord(this.root, word)) {
				removeWord(this.root, word);
			} else {
				return;
			}
		}

		private void removeWord(Node node, String word) {
			if (word.length() == 0) {
				node.isWord = false;
				CountOfWords--;
				return;
			}

			char ch = word.charAt(0);
			removeWord(node.childrens.get(ch), word.substring(1));
			if (!node.childrens.get(ch).isWord && node.childrens.get(ch).childrens.size() == 0) {
				node.childrens.remove(node.data);
				CountOfNodes--;
			}

		}

		public void displayTree() {
			displayTree(this.root);
		}

		private void displayTree(Node node) {
			if (node == null) {
				return;
			}

			StringBuilder ans = new StringBuilder();
			ans.append(node.data + " => ");

			ArrayList<Character> keys = new ArrayList<>(node.childrens.keySet());
			for (Character key : keys) {
				ans.append(key + " => ");
			}

			System.out.println(ans.toString() + ".");

			for (Character key : keys) {
				ans.append(" => " + key);
				displayTree(node.childrens.get(key));
			}

		}

		public void display() {
			display(this.root, "");
		}

		private void display(Node node, String psf) {
			if (node.isWord) {
				System.out.println(psf);
			}

			ArrayList<Character> keys = new ArrayList<>(node.childrens.keySet());
			for (Character key : keys) {
				display(node.childrens.get(key), psf + key);
			}

		}

	}

}
