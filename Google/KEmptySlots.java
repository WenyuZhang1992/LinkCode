/**
 *  683. K Empty Slots
 *  There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. 
 *  In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.
 *
 *  Given an array flowers consists of number from 1 to N. 
 *  Each number in the array represents the place where the flower will open in that day.
 *
 */
class KEmptySlots {

    /**
     * Version 1: Use TreeSet, and sort the elements by its position
     *      Time: O(nlogn)
     *     Space: O(n)
     */
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0 || k <= 0) {
            return -1;
        }

        TreeSet<Integer> set = new TreeSet<Integer>();
        int count = 1;
        for (int flower : flowers) {
            Integer low = set.lower(flower);
            Integer high = set.higher(flower);
            if (low != null && flower - low.intValue() - 1 == k) {
                return count;
            }
            if (high != null && high.intValue() - flower - 1 == k) {
                return count;
            }
            set.add(flower);
            count++;
        }

        return -1;
    }
}