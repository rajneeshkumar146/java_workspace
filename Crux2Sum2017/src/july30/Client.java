package july30;

public class Client {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.addWord("art");
		trie.addWord("arc");
		trie.addWord("and");
		trie.addWord("ant");
		trie.addWord("an");
		trie.addWord("bug");
		trie.addWord("bugs");
		trie.addWord("sea");
		trie.addWord("see");
		trie.addWord("seen");
		
		System.out.println(trie.searchWord("art"));
		System.out.println(trie.searchWord("an"));
		System.out.println(trie.searchWord("buy"));
		
		trie.display();
		
		trie.removeWord("an");
		trie.removeWord("ant");
		
		System.out.println("---------------------------");
		trie.display();
	}

}
