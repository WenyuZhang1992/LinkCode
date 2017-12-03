/**
 *	Given a String input, find out the 10 most frequently occured words in the String
 *  
 *  Follow up: What if the input is too large and can't fit into memory?
 *  Solution: Break the input into smaller blocks, process each block and store the result with their counts
 *            Then the problem becomes Merge K sorted list
 *  Follow up: What if contains comma?
 *  Solution: Use Character.isLetter() to check if the word contains any comma and use StringBuilder to construct
 *            real words, connection operator already been handled by scanner
 */
class FrequentWords {

    /** Version 1: Use HashMap and MinHeap
     *       Time: O(n)
     *      Space: O(n)
     */
    private class wordNode {
        String word;
        int count;

        public wordNode(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    private class wordNodeComparable implements Comparator<wordNode> {
        public int compare(wordNode w1, wordNode w2) {
            return w1.count - w2.count;
        }
    }

    public List<String> frequentWords(String input) {
        List<String> result = new ArrayList<String>();
        if (input == null || input.length() == 0) {
            return result;
        }

        String[] words = input.trim().split("\\s+");
        HashMap<String, wordNode> map = new HashMap();
        Queue<wordNode> heap = new PriorityQueue<wordNode>(new wordNodeComparable());

        for (String word : words) {
            if (!map.containsKey(word.toLowerCase())) {
                map.put(word, new wordNode(word, 1));
            } else {
                map.put(word, new wordNode(word, map.get(word).count + 1));
            }
        }

        for (Map.Entry<String, wordNode> entry : map.entrySet()) {
            heap.add(entry.getValue());
            while (heap.size() > 10) {
                heap.poll();
            }
        }

        while (heap.size() > 0) {
            result.add(heap.poll().word);
        }

        return result;
    }

    /** Version 2: Input File
     *       Time: O(nlogk)
     *      Space: O(n)
     */
    class EmptyFileException extends IOException {
        public EmptyFileException(String message) {
            super(message);
        }
    }

    class LessWordException extends IOException {
        public LessWordException(String message) {
            super(message);
        }
    }

    public void frequentWord(String path, int k) throws IOException {

        Scanner sc = new Scanner(new File(path));
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        sc.close();

        if (map.size() == 0) {
            throw new EmptyFileException("Empty File");
        }

        Queue<String> heap =
                new PriorityQueue<String>(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        if (map.get(s1) == map.get(s2)) {
                            return s2.compareToIgnoreCase(s1);
                        } else {
                            return map.get(s1) - map.get(s2);
                        }
                    }
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.add(entry.getKey());
            while (heap.size() > k) {
                heap.poll();
            }
        }

        if (heap.size() < k) {
            throw new LessWordException("File contains words less than " + k);
        }
        while (heap.size() > 0) {
            String word = heap.poll();
            String output = String.format("%s %d", word, map.get(word));
            System.out.println(output);
        }
    }

    public static void main(String[] argv) {
        Solution s = new Solution();
        try {
            s.frequentWord("/Users/JOHNNY/IdeaProjects/LintCode/src/book.txt", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Version 3: Use Trie Tree and Heap
     *       Time: O(nlogk)
     *      Space: O(n)
     */
    class TrieNode {
        int count;
        TrieNode[] children;

        public TrieNode() {
            count = 0;
            children = new TrieNode[26];
        }

        public void addChild(char c) {
            children[c - 'a'] = new TrieNode();
        }

        public boolean containsChar(char c) {
            return children[c - 'a'] != null;
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }
    }

    private int addWord(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsChar(c)) {
                node.addChild(c);
            }
            node = node.getChild(c);
        }
        node.count = node.count + 1;
        return node.count;
    }

    class WordNode {
        String word;
        int count;

        public WordNode(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public void frequentWords(String path, int k) throws IOException {
        Scanner sc = new Scanner(new File(path));
        TrieNode root = new TrieNode();
        Queue<WordNode> heap = new PriorityQueue<WordNode>(new Comparator<WordNode>() {
            @Override
            public int compare(WordNode w1, WordNode w2) {
                return w1.count - w2.count;
            }
        });

        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            int count = addWord(root, word);
            Iterator<WordNode> iter = heap.iterator();
            while (iter.hasNext()) {
                WordNode temp = iter.next();
                if (temp.word.equals(word)) {
                    iter.remove();
                    break;
                }
            }
            heap.add(new WordNode(word, count));
            while (heap.size() > k) {
                heap.poll();
            }
        }

        while (heap.size() > 0) {
            WordNode wn = heap.poll();
            String output = String.format("%s %d", wn.word, wn.count);
            System.out.println(output);
        }
    }

    public static void main(String[] argv) {
        Solution s = new Solution();
        try {
            s.frequentWords("/Users/JOHNNY/IdeaProjects/LintCode/src/book.txt", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}