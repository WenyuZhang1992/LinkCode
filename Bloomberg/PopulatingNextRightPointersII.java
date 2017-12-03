/**
 *	117. Populating Next Right Pointers in Each Node II
 *	https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 */
class PopulatingNextRightPointersII {

	/**
	 * Version 1: Use 4 pointers to trace prevHead, prevTail, currHead, currTail respectively
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode prevHead = root;
        TreeLinkNode prevTail = root;
        
        TreeLinkNode currHead = findNextHead(prevHead);
        TreeLinkNode currTail = findParent(prevHead);
        
        while (currHead != null) {
            currTail = currHead;
            
            while (prevTail != null) {
                if (prevTail.left != null && prevTail.left != currTail) {
                    currTail.next = prevTail.left;
                    currTail = currTail.next;
                }
                if (prevTail.right != null && prevTail.right != currTail) {
                    currTail.next = prevTail.right;
                    currTail = currTail.next;
                }
                prevTail = prevTail.next;
            }
            
            prevHead = currHead;
            currHead = findNextHead(prevHead);
            prevTail = findParent(prevHead);
        }
    }
    
    private TreeLinkNode findNextHead(TreeLinkNode prevHead) {
        TreeLinkNode temp = prevHead;
        while (temp != null) {
            if (temp.left != null) {
                return temp.left;
            }
            if (temp.right != null) {
                return temp.right;
            }
            temp = temp.next;
        }
        return null;
    }
    
    private TreeLinkNode findParent(TreeLinkNode prevHead) {
        TreeLinkNode temp = prevHead;
        while (temp != null) {
            if (temp.left != null || temp.right != null) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}