class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len=capacity.length,c=0;
        int arr[]=new int[len];
        for(int i=0;i<len;i++)
        {
            arr[i]=capacity[i]-rocks[i];
        }
        
        //qsort(arr,0,0,len-1);
        Arrays.sort(arr);
        int i=0;
        while(arr[i++]==0){
            c++;
            if(i>=len) return c;
        }
        for(i-- ;i<arr.length;i++)
        {
            if(arr[i]<=additionalRocks){
                c++;
                additionalRocks-=arr[i];
            }
            else return c;
        }
        
//         USING PRIORITY QUEUE:O(nlogn) 
//         Queue<Integer> pq=new PriorityQueue<>();
//         for(int a:arr)
//         {
//             pq.add(a);
//         }
//         while(pq.peek()==0)
//         {
//             c++;
//             pq.poll();
//         }
//         while(additionalRocks>0 && !pq.isEmpty())
//         {
            
//             if(additionalRocks>= pq.peek())
//             {
//                 c++;
//                 additionalRocks-=pq.poll();
//             }
//             else break;
//         }
        return c;
    }
    
    // public void qsort(int []arr,int p,int si,int ei)
    // {
    //     int s=si,e=ei;
    //     if(ei<=si) return;
    //     while(s<e)
    //     {
    //         while(arr[s]<=arr[p])
    //         {
    //             s++;
    //             if(s>ei){
    //                 s--;
    //                 break;
    //             }
    //         }
    //         while(arr[e]>arr[p])
    //         {
    //             e--;
    //             if(e>si)
    //             {
    //                 e++;
    //                 break;
    //             }
    //         }
    //         if(s>e){
    //             s--;
    //             e++;
    //             break;
    //         }
    //         int tmp=arr[s];
    //         arr[s]=arr[e];
    //         arr[e]=tmp;
    //     }
    //     int tmp=arr[s];
    //     arr[s]=arr[p];
    //     arr[p]=tmp;
    //     qsort(arr,p,si,s-1);
    //     qsort(arr,s+1,s+1,ei);
    // }
}