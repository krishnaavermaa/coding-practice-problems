class Solution {
    public void duplicateZeros(int[] arr) {
        int c=0;
        int len=arr.length;
        for(int i=0;i<len;i++)
        {
            if(arr[i]==0) c++;
        }
        for(int i=len-1;i>=0;i--)
        {
             if(arr[i]==0)
            {
                if(i+c<len) arr[i+c]=0;
                c--;
             }
            if(i+c<len) arr[i+c]=arr[i];
            //System.out.println("\n"+(i+c));
           
            //for(int j=0;j<len;j++)
             //System.out.print(arr[j]+" ");
        }
        
    }
}