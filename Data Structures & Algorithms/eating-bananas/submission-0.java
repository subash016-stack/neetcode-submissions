class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int left =1;
        int right=0;
        for(int i : piles)
        {
            right=Math.max(i,right);
        }
        int ans=right;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            int hours=0;
            for(int i : piles)
            {
                hours+=Math.ceil((double)i/mid);
            }
            if(hours<=h)
            {
                ans=mid;
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return ans;
    }
}
