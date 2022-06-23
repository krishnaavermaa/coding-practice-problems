class Solution {
    public int findNumbers(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(digits(nums[i])%2==0) c++;
        }
        return c;
    }
    public int digits(int num)
    {
        if(num==0) return 0;
        return digits(num/10)+1;
    }
}