class Solution 
{
    public boolean validTree(int n, int[][] edges) 
    {
        ArrayList<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        for(int[]edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[]visited=new boolean[n];
        if(dfs(graph,visited,0,-1))
            return false;
        for(boolean node:visited)
        {
            if(!node)
            {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<Integer>[]graph,boolean[]visited,int node,int parent)
    {
        visited[node]=true;
        for(int neighbor:graph[node])
        {
            if(neighbor==parent)
                continue;
            if(visited[neighbor])
                return true;
            if(dfs(graph,visited,neighbor,node))
                return true;
        }
        return false;
    }
}
