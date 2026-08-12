class Solution 
{
    public int rob(int[] nums) 
    {
        int one=0;
        int two=0;
        for(int i=0;i<nums.length;i++)
        {
            int current = Math.max(one,two+nums[i]);
            two=one;
            one=current;
        }
        return one;
    }
}
