class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int left=0;
        int right=0;
        int maxfreq=0;
        int maxlength=0;
        HashMap <Character,Integer> map = new HashMap<>();
        while(right<s.length())
        {
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxfreq=Math.max(maxfreq,map.get(ch));
            while((right-left+1)-maxfreq>k)
            {
                char leftch=s.charAt(left);
                map.put(leftch,map.get(leftch)-1);
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
            right++;
        }
        return maxlength;
    }
}
