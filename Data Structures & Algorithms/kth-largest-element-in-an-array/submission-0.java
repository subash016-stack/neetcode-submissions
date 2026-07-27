class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums)
        {
            pq.offer(n);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        if(pq.size()==0)
        {
            return 0;
        }
        return pq.peek();
    }
}
