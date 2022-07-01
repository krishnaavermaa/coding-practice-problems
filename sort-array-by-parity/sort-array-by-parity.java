class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // int c=-1;
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(nums[i]%2==0) c++;
        // }
        // int i=c,j=c+1,k=0;
        // while(i<j && i>=0 && j<=nums.length-1 && c!=-1)
        // {
        //     if(k==i) k=j;
        //     if(nums[k]%2==0)//even
        //     {
        //         int tmp=nums[k];
        //         nums[k]=nums[i];
        //         nums[i]=tmp;
        //         k++;
        //         i--;
        //     }
        //     else
        //     {
        //         int tmp=nums[k];
        //         nums[k]=nums[j];
        //         nums[j]=tmp;
        //         j++;
        //         k++;
        //     }
        //     if(i<=0 && j>=nums.length-1) break;
        // }
        // return nums;
        int i=0,j=nums.length-1;
        while(i<j)
        {
            while(i<nums.length && nums[i]%2==0) i++;
            while(j>=0 && nums[j]%2!=0) j--;
            if(i<j){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;
                j--;
            }
        }
        return nums;
        
    }
}