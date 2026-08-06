class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        ArrayList<Integer>[]graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int[]pre:prerequisites)
        {
            graph[pre[1]].add(pre[0]);
        }
        int[]states=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(dfs(graph,states,i))
                return false;
        }
        return true;
    }
    public boolean dfs(ArrayList<Integer>[]graph,int[]states,int node)
    {
        if(states[node]==1)
            return true;
        if(states[node]==2)
            return false;
        states[node]=1;
        for(int neighbor:graph[node])
        {
            if(dfs(graph,states,neighbor))
                return true;
        }
        states[node]=2;
        return false;
    }
}
