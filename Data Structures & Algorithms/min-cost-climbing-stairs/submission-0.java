class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int one=0;
        int two=0;
        for(int i=2;i<=cost.length;i++)
        {
            int current = Math.min(two+cost[i-1],one+cost[i-2]);
            one=two;
            two=current;
        }
        return two;
    }
}
