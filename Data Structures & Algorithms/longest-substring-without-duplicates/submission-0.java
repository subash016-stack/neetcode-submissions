class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        HashSet<Character> set = new HashSet<>();
        int left=0;
        int right=0;
        int maxlength=0;
        while(right<s.length())
        {
            while(set.contains(s.charAt(right)))
            {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlength=Math.max(maxlength,right-left+1);
            right++;
        }
        return maxlength;
    }
}
