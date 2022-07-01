class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean flag=false;//for increasing
        if(arr.length<3) return false;
        if(arr[0]>=arr[1] || arr[arr.length-2]<=arr[arr.length-1]) return false;
        int prev=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(flag==false)
            {
                if(arr[i]<=prev)
                {
                    if(prev==-1 || arr[i]==prev) return false;
                    flag=true;   
                }
                prev=arr[i];
            }
            else if(flag==true)
            {
                if(arr[i]>=prev)
                {
                    return false;
                }
                prev=arr[i];
            }
        }
        return true;
    }
}