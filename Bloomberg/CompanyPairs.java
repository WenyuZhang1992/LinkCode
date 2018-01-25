/**
 *	Company Pairs:
 *	Given a list of company pairs, pair<A, B> represents company A is the parent of company B;
 *  Design a data structure to store company relationships and to implement getParent(), isRelated() methods.
 */

/** Version 1: Use HashMap and Union-Find;
 *       Time: O(n)
 *      Space: O(n)
 */
class Pair {
    String parent;
    String child;

    public Pair(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }
}

class CompanyPairs {

    HashMap<String, String> map;

    public CompanyPairs(List<Pair> pairs) {
        map = new HashMap();
        for (Pair pair : pairs) {
            union(pair.parent, pair.child);
        }
    }

    public String getParent(String child) {
        if (!map.containsKey(child)) {
            return null;
        }

        return map.get(child);
    }

    public boolean isRelated(String parent, String child) {
        if (!map.containsKey(parent) || !map.containsKey(child)) {
            return false;
        }

        if (find(parent).equals(find(child))) {
            return true;
        }

        return false;
    }

    private String find(String company) {
        if (map.get(company).equals(company)) {
            return company;
        }

        return find(map.get(company));
    }

    private void union(String parent, String child) {
        if (!map.containsKey(parent)) {
            map.put(parent, parent);
        }

        if (!map.containsKey(child)) {
            map.put(child, parent);
        }
    }

    public static void main(String[] argv) {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair("A", "B"));
        pairs.add(new Pair("A", "C"));
        pairs.add(new Pair("B", "D"));
        pairs.add(new Pair("B", "E"));
        pairs.add(new Pair("F", "G"));

        CompanyPairs s = new CompanyPairs(pairs);
        System.out.println(s.getParent("B"));
        System.out.println(s.getParent("C"));
        System.out.println(s.getParent("D"));
        System.out.println(s.getParent("E"));

        System.out.println(s.isRelated("B", "C"));
        System.out.println(s.isRelated("B", "A"));
        System.out.println(s.isRelated("D", "E"));
        System.out.println(s.isRelated("B", "F"));
    }
}