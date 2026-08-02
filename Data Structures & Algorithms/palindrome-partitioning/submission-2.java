class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) 
    {
        backtrack(0,s,new ArrayList<>());
        return result;
    }
    public void backtrack(int index,String s,List<String> path)
    {
        if(index==s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++)
        {
            if(ispalindrome(s,index,i))
            {
                path.add(s.substring(index,i+1));
                backtrack(i+1,s,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean ispalindrome(String s,int left,int right)
    {
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
               return false;
            }
            left++;
            right--;
        }
        return true;
    }
}