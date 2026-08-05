class Solution 
{
    public void islandsAndTreasure(int[][] grid) 
    {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    queue.offer(new int[]{i,j});
                }
            }
        } 
        int[][] dir={
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        while(!queue.isEmpty())
        {
            int current[]=queue.poll();
            int row=current[0];
            int col=current[1];
            for(int d[]:dir)
            {
                int newrow = row+d[0];
                int newcol = col+d[1];
                if(newrow<0||newcol<0||newrow>=grid.length||newcol>=grid[0].length||grid[newrow][newcol]!=Integer.MAX_VALUE)
                    continue;
                grid[newrow][newcol]=grid[row][col]+1;
                queue.offer(new int[]{newrow,newcol});
            }
        }
    }
}
