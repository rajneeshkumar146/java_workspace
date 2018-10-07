package july30;

public class Client {

	public static void main(String[] args) {
//		HuffmanEncoder he = new HuffmanEncoder("aaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbccd");
//		System.out.println(he.encode("ababcd"));
//		System.out.println(he.decode("101101001000"));
		Trie trie = new Trie();
		trie.addWord("and");
		trie.addWord("ant");
		trie.addWord("an");
		trie.addWord("are");
		trie.addWord("art");
		trie.addWord("as");
		trie.addWord("ask");
		trie.addWord("sea");
		trie.addWord("see");
		trie.addWord("seen");
		
//		trie.displayWords();
		
		trie.displayTrie();
		
		System.out.println(trie.searchWord("an"));
		System.out.println(trie.searchWord("ant"));
		
		trie.removeWord("an");
		trie.removeWord("ant");
		trie.removeWord("and");

		System.out.println("------------------------------------");
		System.out.println(trie.searchWord("an"));
		System.out.println(trie.searchWord("ant"));
		
		trie.displayTrie();
//		trie.displayWords();

	}

}
