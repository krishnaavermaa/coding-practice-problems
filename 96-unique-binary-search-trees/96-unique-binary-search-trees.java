class Solution {
    public int numTrees(int n) {
        return (int)(binomial(2*n,n)/(n+1));
    }
    public long binomial(int n,int r)
    {
        long res=1L;
        if(r>n-r) r=n-r;
        for(int i=0;i<r;i++)
        {
            res*=(n-i);
            res/=(i+1);
        }
        return res;
    }
}