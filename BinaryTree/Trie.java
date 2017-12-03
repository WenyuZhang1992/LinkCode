/**
 *	208. Implement Trie (Prefix Tree)
 *	https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
class Trie {

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }

        public void setEnd() { isEnd = true; }

        public boolean containsChar(char c) {
            return children[c - 'a'] != null;
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public void addChild(char c) {
            children[c - 'a'] = new TrieNode();
        }

        public boolean isEnd() { return isEnd; }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /**
     *      Time: O(m) -> m is the length of the word
     *     Space: O(m)
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        TrieNode pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!pointer.containsChar(c)) {
                pointer.addChild(c);
            } 
            pointer = pointer.getChild(c);
        }

        pointer.setEnd();
    }
    
    /**
     *      Time: O(m)
     *     Space: O(1)
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        TrieNode pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!pointer.containsChar(c)) {
                return false;
            } 
            pointer = pointer.getChild(c);
        }

        return pointer.isEnd();
    }
    
    /**
     *      Time: O(m)
     *     Space: O(1)
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }

        TrieNode pointer = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!pointer.containsChar(c)) {
                return false;
            } 
            pointer = pointer.getChild(c);
        }
        return true;
    }
}