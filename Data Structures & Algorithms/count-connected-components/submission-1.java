class Solution {
    public int countComponents(int n, int[][] edges) 
    {
        ArrayList<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges)
        {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int count=0;
        boolean[]visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(graph,visited,i);
            }
        }
        return count;
    }
    public void dfs(ArrayList<Integer>[]graph,boolean[]visited,int node)
    {
        visited[node]=true;
        for(int neighbor:graph[node])
        {
            if(!visited[neighbor])
                dfs(graph,visited,neighbor);
        }
    }
}
