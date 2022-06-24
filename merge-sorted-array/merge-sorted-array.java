class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int i=0,j=m-1;
        for(i=0;i<n;i++,j++)
        {
            for(int k=j;k<m+n && k>=-1;k--)
            {
                int ele=nums2[i];
                if(k==-1 || ele>nums1[k])
                {
                    nums1[k+1]=ele;
                    break;
                }
                else if(ele<=nums1[k])
                    nums1[k+1]=nums1[k];
                
            }
        }
    }
}