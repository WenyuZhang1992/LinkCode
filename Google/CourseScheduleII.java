/**
 *  210. Course Schedule II
 *  https://leetcode.com/problems/course-schedule/description/
 */

class CourseScheduleII {

    /**
     * Version 1: Use Topology Sort;
     *            Use a visited array and a HashSet respectively to check the circle and element visited situation;
     *      Time: O(V + E)
     *     Space: O(n)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) {
            return new int[]{0};
        }

        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int[] edge : prerequisites) {
            int parent = edge[1];
            int child = edge[0];
            adjList[parent].add(child);
        }

        boolean[] visited = new boolean[numCourses];
        HashSet<Integer> set = new HashSet();
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(adjList, visited, stack, i, set)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        int count = 0;
        while (stack.size() > 0) {
            result[count++] = stack.pop();
        }
        return result;
    }

    private boolean dfs(ArrayList<Integer>[] adjList, boolean[] visited, Stack<Integer> stack, int course, HashSet<Integer> set) {
        if (visited[course]) {
            return false;
        } else if (set.contains(course)) {
            return true;
        }

        set.add(course);
        visited[course] = true;
        for (int i : adjList[course]) {
            if (!dfs(adjList, visited, stack, i, set)) {
                return false;
            }
        }
        visited[course] = false;
        stack.push(course);
        return true;
    }
}

