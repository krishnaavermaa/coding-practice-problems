class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len=capacity.length,c=0;
        int arr[]=new int[len];
        for(int i=0;i<len;i++)
        {
            arr[i]=capacity[i]-rocks[i];
        }
        Queue<Integer> pq=new PriorityQueue<>();
        for(int a:arr)
        {
            pq.add(a);
        }
        while(pq.peek()==0)
        {
            c++;
            pq.poll();
        }
        while(additionalRocks>0 && !pq.isEmpty())
        {
            
            if(additionalRocks>= pq.peek())
            {
                c++;
                additionalRocks-=pq.poll();
            }
            else break;
        }
        return c;
    }
}