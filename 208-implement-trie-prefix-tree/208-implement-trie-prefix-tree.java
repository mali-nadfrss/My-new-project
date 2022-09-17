class Trie {

    class TrieNode {

    Map<Character, TrieNode> map;
    boolean isEndOfWord ;

    TrieNode() {
      map = new HashMap<>();
    }
  }

  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    insertRecursion(word, root, 0);
  }

  void insertRecursion(String word, TrieNode root, int index) {

    if (index >= word.length()) {
      root.isEndOfWord = true;
      return;
    }
    TrieNode cur = root.map.get(word.charAt(index));
    if (cur == null) {
      cur = new TrieNode();
      root.map.put(word.charAt(index), cur);
    }
    insertRecursion(word, cur, index + 1);
  }

  public boolean search(String word) {
    return searchRecursion(word, 0, root, true);
  }

  boolean searchRecursion(String word, int index, TrieNode node, boolean exactMatch) {
    if (index >= word.length()) {
      if (exactMatch) return node.isEndOfWord;
      return true;
    }
    TrieNode cur = node.map.get(word.charAt(index));
    if (cur != null) {
      return searchRecursion(word, index + 1, cur, exactMatch);
    } else {
      return false;
    }
  }

  public boolean startsWith(String prefix) {
    return searchRecursion(prefix, 0, root, false);
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */