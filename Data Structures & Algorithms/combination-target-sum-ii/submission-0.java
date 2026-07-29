class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        backtrack(0,candidates,target,0,new ArrayList<>());
        return result;
    }
    public void backtrack(int index,int[] nums,int target,int sum,List<Integer>subset)
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
            if(i>index && nums[i]==nums[i-1])
            {
                continue;
            }
            subset.add(nums[i]);
            backtrack(i+1,nums,target,sum+nums[i],subset);
            subset.remove(subset.size()-1);
        }
    }
}
