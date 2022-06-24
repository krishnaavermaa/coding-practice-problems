class Solution {
    public int removeElement(int[] nums, int val) {
        int shiftBit=0;
        for(int i=0;i<nums.length;i++)
        {
            int j=i+shiftBit;
            if(j>=nums.length) break;
            if(nums[j]==val)
            {
                shiftBit++;
                
                nums[i]=nums[j];
                
                i--;
                continue;
            }
            
            nums[i]=nums[j];
        }
        return nums.length-shiftBit;
    }
}