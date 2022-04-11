class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        //s=s.toLowerCase();
        //t=t.toLowerCase();
        //int []tcount=new int[26];
        int []count=new int[26];
        int k=0;
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)-97]+=1;
        }
        for(int i=0;i<s.length();i++)
        {
            k=t.charAt(i)-97;
            count[k]-=1;
            if(count[k]<0) return false;
        }
        return true;
        
        
    }
}