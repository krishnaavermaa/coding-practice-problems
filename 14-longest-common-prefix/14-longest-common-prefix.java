class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len=strs[0].length();
        String res="";
        boolean flag=false;
        for(int i=0;i<len;i++)
        {
            int j=1;
            for( ;j<strs.length;j++)
            {
                //if(strs[j].length()<len) len=strs[j].length();
               // System.out.println(j+"_"+i+"_"+strs[j]+"_"+len);
                if(j==1)
                    if(strs[j].length()<len)
                         len=strs[j].length();
                if(strs[j].length()-1<i) return res;;
                //if(i>=len) flag=true;
                //else
                if(strs[j].charAt(i)!=strs[j-1].charAt(i)) return res;
            }
            res=res+String.valueOf(strs[j-1].charAt(i));
        }
        return res;
    }
}