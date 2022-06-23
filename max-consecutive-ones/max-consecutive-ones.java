class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int temp=0;
        for(int i=0;i<nums.length;i++)
        {
            temp++;
            if(nums[i]!=1) temp=0;
            if(temp>max) max=temp;
        }
        return max;
    }
}