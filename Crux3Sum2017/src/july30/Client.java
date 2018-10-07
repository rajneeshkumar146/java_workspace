package july30;

public class Client {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
//		trie.addWord("and");
		trie.addWord("ant");
		trie.addWord("arc");
		trie.addWord("art");
		trie.addWord("an");
		
		trie.addWord("buy");
		trie.addWord("but");
		trie.addWord("bug");
		
		trie.addWord("sea");
		trie.addWord("seen");
		
		System.out.println(trie.searchWord("ant"));
		System.out.println(trie.searchWord("an"));
		System.out.println(trie.searchWord("bull"));
		System.out.println(trie.searchWord("see"));
		
		trie.display();
		
		trie.removeWord("an");
		trie.removeWord("ant");
		
		System.out.println("-------------------------------------------");
		trie.display();
	}

}
