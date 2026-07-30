class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) 
    {  
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used,new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums,boolean[]used,List<Integer>subset)
    {
        if(subset.size()==nums.length){
            result.add(new ArrayList(subset));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i])
            {
                continue;
            }
            used[i]=true;
            subset.add(nums[i]);
            backtrack(nums,used,subset);
            subset.remove(subset.size()-1);
            used[i]=false;
        }
    }
}
