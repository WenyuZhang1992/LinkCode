/**
 *	208. Implement Trie (Prefix Tree)
 *	https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */

/**
 * Version 1: Use Trie Tree
 *      Time: O(k) -> k is the length of the string
 *     Space: O(k)
 */
class Trie {

	class TrieNode {

		boolean isEnd;
		TrieNode[] children;

		public TrieNode() {
			isEnd = false;
			children = new TrieNode[26];
		}

		public boolean containsChild(char c) {
			return children[c - 'a'] != null;
		}

		public void addChild(char c) {
			children[c - 'a'] = new TrieNode();
		}

		public TrieNode getChild(char c) {
			return children[c - 'a'];
		}
	}

	TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (!temp.containsChild(c)) {
        		temp.addChild(c);
        	}
        	temp = temp.getChild(c);
        }
        temp.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (!temp.containsChild(c)) {
        		return false;
        	} else {
        		temp = temp.getChild(c);
        	}
        }
        return temp.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
        	char c = prefix.charAt(i);
        	if (!temp.containsChild(c)) {
        		return false;
        	} else {
        		temp = temp.getChild(c);
        	}
        }
        return true;
    }
}