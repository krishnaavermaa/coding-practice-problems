import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int lcs=0;
        for(int n:nums){
            set.add(n);
        }
        Iterator it=set.iterator();
        while(it.hasNext()){
            int ele=(int)it.next();
            int c=0;
            if(set.contains(ele-1)) continue;
            while(set.contains(ele++))
            {
                c++;
            }
            lcs=Math.max(c,lcs);
        }
        return lcs;
    }
}