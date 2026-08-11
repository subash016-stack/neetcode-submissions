class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        int[] parent = new int[edges.length+1];
        for(int i=1;i<parent.length;i++)
        {
            parent[i]=i;
        }
        for(int[]edge:edges)
        {
            int u=edge[0];
            int v=edge[1];
            int rootu=find(parent,u);
            int rootv=find(parent,v);
            if(rootu==rootv)
                return edge;
            parent[rootu]=rootv;
        }
        return new int[0];
    }
    public int find(int[]parent,int node)
    {
        if(parent[node]!=node)
        {
            parent[node]=find(parent,parent[node]);
        }
        return parent[node];
    }
}
