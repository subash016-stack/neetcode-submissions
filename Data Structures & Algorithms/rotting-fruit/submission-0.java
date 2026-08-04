class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        int minutes = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Find rotten and fresh oranges
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});

                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[][] dir = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            minutes++;

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for (int[] d : dir) {

                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if (newRow < 0 || newCol < 0 ||
                        newRow >= rows || newCol >= cols ||
                        grid[newRow][newCol] != 1)
                        continue;

                    grid[newRow][newCol] = 2;

                    fresh--;

                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}