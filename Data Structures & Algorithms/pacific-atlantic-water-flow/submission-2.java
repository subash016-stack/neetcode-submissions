class Solution 
{
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        boolean[][]pacific=new boolean[heights.length][heights[0].length];
        boolean[][]atlantic=new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++)
        {
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,heights[0].length-1);
        }
        for(int j=0;j<heights[0].length;j++)
        {
            dfs(heights,pacific,0,j);
            dfs(heights,atlantic,heights.length-1,j);
        }
        List<List<Integer>>result=new ArrayList<>();
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                if(pacific[i][j]&&atlantic[i][j])
                {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    public void dfs(int[][]heights,boolean[][]visited,int row,int col)
    {
        visited[row][col]=true;
        int[][] dir={
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        for(int d[]:dir)
        {
            int newrow=row+d[0];
            int newcol=col+d[1];
            if(newrow<0||newcol<0||newrow>=heights.length||newcol>=heights[0].length||visited[newrow][newcol]||heights[newrow][newcol]<heights[row][col])
            continue;
        dfs(heights,visited,newrow,newcol);
        }
    }
}
