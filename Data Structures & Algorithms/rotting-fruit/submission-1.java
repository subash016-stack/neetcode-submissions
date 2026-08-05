class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        Queue<int[]>queue=new LinkedList<>();
        int minutes=0;
        int fresh=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        int[][] dir={
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        while(!queue.isEmpty()&&fresh>0)
        {
            minutes++;
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int current[]=queue.poll();
                int row=current[0];
                int col=current[1];
                for(int[]d:dir)
                {
                    int newrow=row+d[0];
                    int newcol=col+d[1];
                if(newrow<0||newcol<0||newrow>=grid.length||newcol>=grid[0].length||grid[newrow][newcol]!=1)
                    continue;
                grid[newrow][newcol]=2;
                fresh--;
                queue.offer(new int[]{newrow,newcol});
                }
            }
        }
        return fresh==0?minutes:-1;
    }
}
