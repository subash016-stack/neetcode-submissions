class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        backtrack(0,nums,target,0,new ArrayList<>());
        return result;
    }
    public void backtrack(int index,int[]nums,int target,int sum,List<Integer>subset)
    {
        if(sum==target)
        {
            result.add(new ArrayList<>(subset));
            return;
        }
        if(sum>target)
        {
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            subset.add(nums[i]);
            backtrack(i,nums,target,sum+nums[i],subset);
            subset.remove(subset.size()-1);
        }
    }
}
