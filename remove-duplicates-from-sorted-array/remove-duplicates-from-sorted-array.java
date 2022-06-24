class Solution {
    public int removeDuplicates(int[] nums) {
        int prev=nums[0];
        int next;
        int shiftBit=0;
        for(int i=1;i<nums.length;i++)
        {
            if(i+shiftBit>=nums.length) break; 
            next=nums[i+shiftBit];
            if(next==prev)
            {
                shiftBit++;
                i--;
            }
            else
            {
                nums[i]=next;
                prev=next;
            }
        }
        return nums.length-shiftBit;
    }
}