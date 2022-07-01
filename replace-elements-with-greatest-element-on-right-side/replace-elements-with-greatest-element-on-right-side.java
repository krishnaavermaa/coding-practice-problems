class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            if(i==arr.length-1) arr[i]=-1;
            else{
                int j=i+1;
                int largest=arr[j];
                for( ;j<arr.length;j++)
                {
                    if(arr[j]>largest) largest=arr[j];
                }
                arr[i]=largest;
            }
        }
        return arr;
    }
}