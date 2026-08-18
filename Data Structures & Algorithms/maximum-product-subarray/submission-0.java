class Solution 
{
    public int maxProduct(int[] nums) 
    {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++)
        {
            int oldmax = max;
            int oldmin = min;
            max = Math.max(nums[i],Math.max(nums[i]*oldmax,nums[i]*oldmin));
            min = Math.min(nums[i],Math.min(nums[i]*oldmax,nums[i]*oldmin));
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
