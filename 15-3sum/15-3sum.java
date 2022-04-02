class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=1,k=nums.length-1;
        int sum=0;
        List<Integer> l;
        List<List<Integer>> ll=new ArrayList<>();
        //LinkedHashSet<List<Integer>> lhs=new LinkedHashSet<>();
        for( ;i<nums.length-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;//if ele[i] repeating, continue(i++)
            j=i+1;
            k=nums.length-1;
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==sum)
                {
                    l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    //lhs.add(l);
                    ll.add(l);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;//if ele[j] repeating, j++
                    while(nums[k]==nums[k+1] && j<k) k--;//if ele[k] repeating, k--
                }
                else if(nums[i]+nums[j]+nums[k]<sum)
                {
                    j++;
                    //while(j<k && nums[j]==nums[j-1]) j++;
                }
                else if(nums[i]+nums[j]+nums[k]>sum)
                {
                    k--;
                    //while(nums[k]==nums[k+1] && j<k) k--;
                }
                
                
            }
            //System.out.println(ll);
        }
        return ll;
        
    }
}