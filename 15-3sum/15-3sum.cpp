class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        //set<vector<int> > s;
        sort(nums.begin(),nums.end());
        for(int i=0;i+2<nums.size();i++)
        {
            if(i>0 and nums[i]==nums[i-1]) continue;
            int j=nums.size()-1;
            int k=i+1;
            while(k<j)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    vector<int> v;
                    v.push_back(nums[i]);
                    v.push_back(nums[k]);
                    v.push_back(nums[j]);
                    res.push_back(v);
                    
                    j--;
                    while(k<j and nums[j]==nums[j+1])
                        j--;
                    
                    
                }
                else if(nums[i]+nums[j]+nums[k]>0)
                    j--;
                else
                    k++;
                    
            }         
        }
        return res;
        
    }
};