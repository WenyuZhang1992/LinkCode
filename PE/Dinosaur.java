/**
 *	Dinosaur: 
 *  Dataset1: Name, legLength, someFeature
 *  DataSet2: Name, featureD1, Stance
 *
 * Follow up: what is the data set is too large and can't fit into memory?
 *  Solution: Break datasets into smaller files, store the sorted results in files separately
 *            Then the problem becomes Merge K sorted linked list
 */
class Dinosaur {
	
	private class DinosaurNode {
        String name;
        int speed;

        public DinosaurNode(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }
    }

    private class DinosaurComparator implements Comparator<DinosaurNode> {
        public int compare(DinosaurNode d1, DinosaurNode d2) {
            return d1.speed - d2.speed;
        }
    }

    private int speed(int arg1, int arg2) {
        return arg1 * arg2;
    }
    /**
     * Version 1: Input as String
     *      Time: O(n)
     *     Space: O(n)
     */
    public List<String> dinosaur(String[] file1, String[] file2) {
        HashMap<String, Integer> map2 = new HashMap();
        for (String s : file2) {
            String[] temp = s.trim().split("\\s*,\\s*");
            if (temp[2].trim().equals("twoLegs")) {
                map2.put(temp[0], Integer.parseInt(temp[1]));
            }
        }

        Queue<DinosaurNode> minHeap = new PriorityQueue(new DinosaurComparator());
        for (String s : file1) {
            String[] temp = s.trim().split("\\s*,\\s*");
            if (map2.containsKey(temp[0])) {
                DinosaurNode d = new DinosaurNode(temp[0], speed(Integer.parseInt(temp[1]), map2.get(temp[0])));
                minHeap.add(d);
            }
        }

        List<String> result = new ArrayList();
        while (minHeap.size() != 0) {
            result.add(minHeap.poll().name);
        }

        return result;
    }

    /**
     * Version 2: Input as File
     *      Time: O(n)
     *     Space: O(n)
     */
    public List<String> dinosaur(String f1, String f2) throws IOException {
        List<String> result = new ArrayList();

        Scanner s1 = new Scanner(new File(f1));
        Scanner s2 = new Scanner(new File(f2));
        HashMap<String, Integer> map = new HashMap();
        Queue<String> heap = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return map.get(s1) - map.get(s2);
            }
        });

        while (s2.hasNextLine()) {
            String[] strs = s2.nextLine().trim().split("\\s*,\\s*");
            if (strs.length != 3) {
                throw new InvalidFileException("Invalid file format");
            }
            if (strs[2].equals("twoLegs")) {
                map.put(strs[0], Integer.parseInt(strs[1]));
            }
        }
        s2.close();

        while (s1.hasNextLine()) {
            String[] strs = s1.nextLine().trim().split("\\s*,\\s*");
            if (strs.length != 3) {
                throw new InvalidFileException("Invalid file format");
            }
            if (map.containsKey(strs[0])) {
                map.put(strs[0], speed(map.get(strs[0]), Integer.parseInt(strs[1])));
                heap.add(strs[0]);
            }
        }
        s1.close();

        while (heap.size() > 0) {
            result.add(heap.poll());
        }

        return result;
    }

    // Define custom exception
    class InvalidFileException extends IOException {
        public InvalidFileException(String message) {
            super(message);
        }
    }

    public static void main(String[] argv) {
        String[] file1 = {
                "dinosaur1,  30",
                "dinosaur2,  40",
                "dinosaur4,  30"
        };
        String[] file2 = {
                "dinosaur1,  10, twoLegs",
                "dinosaur2,  10, twoLegs",
                "dinosaur3,  30, twoLegs",
                "dinosaur4,  30, fourLegs"
        };

        Solution d1 = new Solution();
        try {
            List<String> result = d1.dinosaur("/Users/JOHNNY/IdeaProjects/LintCode/src/file1.txt",
                    "/Users/JOHNNY/IdeaProjects/LintCode/src/file2.txt");
            for (String s : result) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}