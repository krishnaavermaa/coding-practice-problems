class Solution {
    public void moveZeroes(int[] nums) {
        int shiftBit=0,i=0;
        for( ;i+shiftBit<nums.length;i++)
        {
            if(nums[i+shiftBit]==0) 
            {
                shiftBit++;
                i--;
                continue;
            }
            nums[i]=nums[i+shiftBit];
        }
        for( ;i<nums.length;i++)
        {
            nums[i]=0;
        }
    }
}