class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) 
    {
        backtrack(0,nums,new ArrayList<>());
        return result;
    }
    public void backtrack(int index,int[] nums,List<Integer> subset)
    {
        result.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++ )
        {
            subset.add(nums[i]);
            backtrack(i+1,nums,subset);
            subset.remove(subset.size()-1);
        }
    }
}
