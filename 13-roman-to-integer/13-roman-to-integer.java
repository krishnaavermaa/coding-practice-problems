class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        int sum=0,p=0;
        char c=' ';
        while(n-->0)
        {
            int res=0;
            c=s.charAt(n);
            p=evaluate(c,p);
            sum=sum+p;
        }
        //System.out.print("_");
        return sum;
    }
    public int evaluate(char c,int p)
    {
        //System.out.print("_");
        int res=0;
        switch(c)
        {
            case 'I':
                res=1;
                break;
            case 'V':
                res=5;
                break;
            case 'X': 
                res=10;
                break;
            case 'L': 
                res=50;
                break;
            case 'C': 
                res=100;
                break;
            case 'D': 
                res=500;
                break;
            case 'M': 
                res=1000;
                break;
        }
        if(res<p) return (-1)*res;
        return res;
    }
    
    
}