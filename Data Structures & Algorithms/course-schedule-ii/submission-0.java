class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
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
        List<Integer>order=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(dfs(graph,states,i,order))
             return new int[0];
        }
        Collections.reverse(order);
        int[]arr=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            arr[i]=order.get(i);
        }
        return arr;
    }
    public boolean dfs(ArrayList<Integer>[]graph,int[]states,int node,List<Integer>order)
    {
        if(states[node]==1)
            return true;
        if(states[node]==2)
            return false;
        states[node]=1;
        for(int neighbor:graph[node])
        {
            if(dfs(graph,states,neighbor,order))
                return true;
        }
        states[node]=2;
        order.add(node);
        return false;
    }
}
