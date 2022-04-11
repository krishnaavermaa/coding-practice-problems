class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int i=0,j=nums.length-1;
        int[][] a=new int[j+1][2];
        for(int k=0;k<=j;k++)
        {
            a[k][0]=k;
            a[k][1]=nums[k];
        }
        
        Arrays.sort(a,(x,y)->Long.compare(x[1],y[1]));
        while(i<j)
        {
            long sum=a[i][1]+a[j][1];
            if(sum==target)
                return new int[]{a[i][0],a[j][0]};
            else if(sum<target) i++;
            else j--;
        }
        return new int[]{-1,-1};
    }
}