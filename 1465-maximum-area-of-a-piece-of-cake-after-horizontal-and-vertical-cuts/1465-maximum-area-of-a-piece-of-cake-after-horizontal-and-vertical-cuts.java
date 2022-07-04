class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mxH=horizontalCuts[0],mxW=verticalCuts[0];
        int tmp=0;
        for(int i=1;i<horizontalCuts.length;i++)
        {
            tmp=horizontalCuts[i]-horizontalCuts[i-1];
            if(tmp>mxH) mxH=tmp;
        }
        tmp=h-horizontalCuts[horizontalCuts.length-1];
        if(tmp>mxH) mxH=tmp;
        
        for(int i=1;i<verticalCuts.length;i++)
        {
            tmp=verticalCuts[i]-verticalCuts[i-1];
            if(tmp>mxW) mxW=tmp;
        }
        tmp=w-verticalCuts[verticalCuts.length-1];
        if(tmp>mxW) mxW=tmp;
        //System.out.println(mxW+" "+mxH+" "+((long)mxH*(long)mxW)+" "+(mxH*mxW)%(Math.pow(10,9)+7));
        return (int)(((long)mxH*mxW)%1000000007);
        
    }
}