class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len=nums.length;
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new LinkedList<>();
        for(int i=1;i<=len;i++){
            set.add(i);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i])) set.remove(nums[i]);
        }
        list.addAll(set);
        return list;
    }
}