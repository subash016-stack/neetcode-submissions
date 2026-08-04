class Solution {

    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        // Add all gates to queue
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) {

                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] d : dir) {

                int newRow = row + d[0];
                int newCol = col + d[1];

                if (newRow < 0 || newCol < 0 ||
                    newRow >= rows || newCol >= cols ||
                    grid[newRow][newCol] != Integer.MAX_VALUE)
                    continue;

                grid[newRow][newCol] = grid[row][col] + 1;

                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}