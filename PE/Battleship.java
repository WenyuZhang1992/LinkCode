/**
 *	Given a N*N square, find the position of the battle ship
 */
class Battleship {

	/** Version 1: Traverse through the map
     *       Time: O(n^2)
     *      Space: O(1)
     */
    class NoSuchBattleShipException extends Exception {
        public NoSuchBattleShipException(String message) {
            super(message);
        }
    }

    class InvalidMapException extends Exception {
        public InvalidMapException(String message) {
            super(message);
        }
    }

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void print() {
            System.out.println("x: " + this.x + " y: " + this.y);
        }
    }

    public List<Coordinate> findBattleShip(int[][] map) throws Exception {
        if (map == null || map.length == 0 || map[0].length == 0) {
            throw new InvalidMapException("Invalid Map");
        }

        System.out.println(map.length + " " + map[0].length);
        List<Coordinate> result = new ArrayList<Coordinate>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1 && isShip(map, i, j, result)) {
                    return result;
                }
            }
        }

        throw new NoSuchBattleShipException("There is no such battleship");
    }

    private boolean isShip(int[][] map, int i, int j, List<Coordinate> result) {
        // Check horizontal
        if (j <= map[0].length - 3 && map[i][j + 1] == 1 && map[i][j + 2] == 1) {
            result.add(new Coordinate(i, j));
            result.add(new Coordinate(i, j + 1));
            result.add(new Coordinate(i, j + 2));
            return true;
        }

        // Check vertically
        if (i <= map.length - 3 && map[i + 1][j] == 1 && map[i + 2][j] == 1) {
            result.add(new Coordinate(i, j));
            result.add(new Coordinate(i + 1, j));
            result.add(new Coordinate(i + 2, j));
            return true;
        }

        return false;
    }


    // For test only
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] map = {{0, 0, 0},
                       {1, 1, 1},
                       {0, 0, 0}};
        try {
            List<Coordinate> result = s.findBattleShip(map);

            for (Coordinate c : result) {
                c.print();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}