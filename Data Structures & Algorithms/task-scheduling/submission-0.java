class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] freq = new int[26];
        for(char i : tasks)
        {
            freq[i-'A']++;
        }
        for(int i : freq)
        {
            if(i>0)
            {
                pq.offer(i);
            }
        }
        int time=0;
        while(!pq.isEmpty())
        {
            List<Integer>temp = new ArrayList<>();
            int cycle = n+1;
            while(cycle>0 && !pq.isEmpty())
            {
                int count = pq.poll();
                count--;
                if(count>0)
                    temp.add(count);

                time++;
                cycle--;
            }
            for(int num : temp)
            {
                pq.offer(num);
            }
            if(pq.isEmpty())
                break;
            time+=cycle;
        }
    return time;
    }
}
