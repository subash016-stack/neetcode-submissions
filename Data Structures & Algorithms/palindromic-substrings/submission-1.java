class Solution {
    public int countSubstrings(String s) 
    {
        int n=s.length();
        boolean[]dp=new boolean[n];
        int count=0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>=i;j--)
            {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[j-1]))
                {
                    dp[j]=true;
                    count++;
                }
                else
                {
                    dp[j]=false;
                }
            }
        } 
        return count;  
    }
    
}
