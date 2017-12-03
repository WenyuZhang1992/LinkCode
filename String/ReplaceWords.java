/**
 *	648. Replace Words
 *	https://leetcode.com/problems/replace-words/description/
 */
class ReplaceWords {
	
	/**
	 * Version 1: Use Trie to store all dict roots
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	class TrieNode {
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
        
        public boolean containsChild(char c) {
            return children[(int)(c - 'a')] != null;
        }
        
        public TrieNode getChild(char c) {
            return children[(int)(c - 'a')];
        }
        
        public void addChild(char c) {
            children[c - 'a'] = new TrieNode();
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        String[] strs = sentence.trim().split("\\s+");
        TrieNode root = new TrieNode();
        
        // Add roots into Trie
        for (String word : dict) {
            addWord(root, word);
        }
        
        // Search each word from Trie
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            String temp = searchWord(root, str);
            if (!temp.equals("")) {
                sb.append(temp);
            } else {
                sb.append(str);
            }
            sb.append(" ");
        }
        
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    
    private void addWord(TrieNode root, String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (!p.containsChild(word.charAt(i))) {
                p.addChild(word.charAt(i));
            }
            p = p.getChild(word.charAt(i));
        }
        p.isWord = true;
    }
    
    private String searchWord(TrieNode root, String word) {
        TrieNode p = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (p.isWord) {
                break;
            }
            if (!p.containsChild(word.charAt(i))) {
                return "";
            }
            sb.append(word.charAt(i));
            p = p.getChild(word.charAt(i));
        }
        
        return sb.toString();
    }
}