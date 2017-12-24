/**
 *  207. Course Schedule
 *  https://leetcode.com/problems/course-schedule/description/
 */

class CourseSchedule {

    /**
     * Version 1: Use DFS
     *            Firstly transform the prequisites into adjacent lists;
     *            Then traverse the adjList to ckeck if a circle exists
     *      Time:
     *     Space:
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) {
            return true;
        }

        List<List<Integer>> adjList = new ArrayList();
        int length = prerequisites.length;

        // Initialize the adjList
        for (int i = 0; i < numCourses; ++i) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < length; ++i) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            adjList.get(parent).add(child);
        }
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            if (dfs(adjList, visited, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, boolean[] visited, int course) {
        if (visited[course]) {
            return true;
        }

        visited[course] = true;
        for (int i = 0; i < adjList.get(course).size(); i++) {
            if (dfs(adjList, visited, adjList.get(course).get(i))) {
                return true;
            }
        }
        visited[course] = false;
        return false;
    }

    /**
     * Version 1: Use BFS
     *      Time:
     *     Space:
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) {
            return true;
        }

        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }

        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int parent = edge[1];
            int child = edge[0];
            adjList[parent].add(child);
            inDegree[child] = inDegree[child] + 1;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (queue.size() > 0) {
            int course = queue.poll();
            for (int i : adjList[course]) {
                inDegree[i] = inDegree[i] - 1;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

