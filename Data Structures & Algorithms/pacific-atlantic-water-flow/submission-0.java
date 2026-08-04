class Solution {

    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, rows - 1, j);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (pacific[i][j] && atlantic[i][j]) {

                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    public void dfs(int[][] heights,
                    boolean[][] visited,
                    int row,
                    int col) {

        visited[row][col] = true;

        int[][] dir = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        for (int[] d : dir) {

            int newRow = row + d[0];
            int newCol = col + d[1];

            if (newRow < 0 || newCol < 0 ||
                newRow >= rows || newCol >= cols ||
                visited[newRow][newCol] ||
                heights[newRow][newCol] < heights[row][col])
                continue;

            dfs(heights, visited, newRow, newCol);
        }
    }
}