/**
 *  735. Asteroid Collision
 *  https://leetcode.com/problems/asteroid-collision/description/
 */

class AsteroidCollision {

    /**
     * Version 1: Use stack;
     *            There're three situations:
     *            1. New element and stack.peek() have same sign, directly push;
     *            2. New element is positive and stack.peek() is negative, directly push;
     *            3. New element is negative and stack.peek() is positive, need to pop out the peek and compare their absolute values;
     *      Time: O(n)
     *     Space: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) {
            return asteroids;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int index = 0;
        while (index < asteroids.length) {
            if (stack.size() == 0 || stack.peek() * asteroids[index] > 0) {
                stack.push(asteroids[index++]);
                continue;
            }

            int curr = asteroids[index];
            if (stack.peek() < 0 && curr > 0) {
                stack.push(asteroids[index++]);
                continue;
            }

            int prev = stack.pop();
            int insert = 0;
            while (true) {
                if (prev > -curr) {
                    insert = prev;
                    break;
                } else if (prev == -curr) {
                    break;
                } else {
                    if (stack.size() > 0 && stack.peek() * curr > 0) {
                        insert = curr;
                        break;
                    } else if (stack.size() > 0) {
                        prev = stack.pop();
                    } else {
                        insert = prev > -curr ? prev : curr;
                        break;
                    }
                }
            }
            if (insert != 0) {
                stack.push(insert);
            }
            index++;
        }

        int[] result = new int[stack.size()];
        int i = result.length - 1;
        while (i >= 0) {
            result[i--] = stack.pop();
        }
        return result;
    }
}

