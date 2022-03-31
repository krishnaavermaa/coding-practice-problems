class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        int sum=0,p=0;
        while(n-->0)
        {
            int temp;
            temp=evaluate(s.charAt(n));
            p=temp<p?(-1)*temp:temp;
            sum=sum+p;
        }
        //System.out.print("_");
        return sum;
    }
    public int evaluate(char c)
    {
        //System.out.print("_");
        switch(c)
        {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X': 
                return 10;
            case 'L': 
                return 50;
            case 'C': 
               return 100;
            case 'D': 
                return 500;
            case 'M': 
                return 1000;
        }
        //if(res<p) return (-1)*res;
        return 0;
    }
    
    
}