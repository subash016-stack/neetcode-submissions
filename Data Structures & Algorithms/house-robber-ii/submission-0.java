class Solution
{
    public int rob(int[] nums) 
    {
        if(nums.length==1)
            return nums[0];
        
        int case1 = robhouse(nums,0,nums.length-2);
        int case2 = robhouse(nums,1,nums.length-1);
        return Math.max(case1,case2);
    }
    public int robhouse(int[]nums,int start,int end)
    {
        int one=0;
        int two=0;
        for(int i=start;i<=end;i++)
        {
            int current = Math.max(one,two+nums[i]);
            two=one;
            one=current;
        }
        return one;
    }
}
