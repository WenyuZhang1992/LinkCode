/**
 *	380. Insert Delete GetRandom O(1)
 *	https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */

/**
 * Version 1: Use an array to store the values and a HashMap to store value<->index pair
 *            Every insert a new value to the end of the list and update the map
 *            Every delete a value, replace it with the last element in the list, update the map
 *                  if the value is the last element of the array, directly delete it
 *            Random index generated from 0(inclusive) - size(exclusive)
 *      Time: O(1)
 *     Space: O(n)
 */
class RandomizedSet {

    int size;
    Random random;
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    
    public RandomizedSet() {
        size = 0;
        random = new Random();
        list = new ArrayList();
        map = new HashMap();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        list.add(size, val);
        map.put(val, size++);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        if (map.get(val) == size - 1) {
            size--;
        } else {
            int replace = list.get(--size);
            list.set(map.get(val), replace);
            map.put(replace, map.get(val));
        }
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        // Notice: nexInt(int n) -> 0 is inclusive, n is exclusive
        int index = random.nextInt(size);
        return list.get(index);
    }
}