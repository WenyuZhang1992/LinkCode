/**
 *	Company Structure:
 *	Given a list of parent company and child company pairs, construct a data structure to store the company structures.
 *	The data structure should be able to: 
 *		1. find the parent company of any child company;
 *		2. Check if two child companies share the same parent company;
 *		3. Check if a company is another's uncle company;
 */
class TreeNode {
    String name;
    TreeNode parent;

    public TreeNode(String name) {
        this.name = name;
        parent = null;
    }
}

class Pair {
    String parentCompany;
    String childCompany;

    public Pair(String parent, String child) {
        this.parentCompany = parent;
        this.childCompany = child;
    }
}

public class CompanyStructure {

    HashMap<String, TreeNode> map = new HashMap<>();

    public CompanyStructure(List<Pair> pairs) {
        for (Pair p : pairs) {
            TreeNode parentNode = null;
            TreeNode childNode = null;

            if (!map.containsKey(p.parentCompany)) {
                parentNode = new TreeNode(p.parentCompany);
            } else {
                parentNode = map.get(p.parentCompany);
            }

            if (!map.containsKey(p.childCompany)) {
                childNode = new TreeNode(p.childCompany);
            } else {
                childNode = map.get(p.childCompany);
            }

            childNode.parent = parentNode;
            if (!map.containsKey(p.parentCompany)) {
                map.put(p.parentCompany, parentNode);
            }
            if (!map.containsKey(p.childCompany)) {
                map.put(p.childCompany, childNode);
            }
        }
    }

    public String findParent(String child) throws Exception {
        if (!map.containsKey(child)) {
            throw new Exception("No such child company!");
        }

        TreeNode childNode = map.get(child);
        if (childNode.parent == null) {
            throw new Exception("This company has no parent company!");
        }

        return childNode.parent.name;
    }

    public boolean findCommonParent(String child1, String child2) {
        if (!map.containsKey(child1) || !map.containsKey(child2)) {
            return false;
        }

        TreeNode childNode1 = map.get(child1);
        TreeNode childNode2 = map.get(child2);

        if (childNode1.parent == null || childNode2.parent == null) {
            return false;
        }

        return childNode1.parent.name == childNode2.parent.name;
    }

    public boolean isUncle(String uncle, String child) {
        if (!map.containsKey(child)) {
            return false;
        }

        TreeNode childNode = map.get(child);
        if (childNode.parent == null) {
            return false;
        }
        return findCommonParent(uncle, childNode.parent.name);
    }
}