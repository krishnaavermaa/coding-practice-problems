class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->{return b[1]-a[1];});
        int res=0;
        // for(int i=0;i<boxTypes.length;i++)
        // {
        //     System.out.println(boxTypes[i][0]+" "+boxTypes[i][1]);
        //}
        for(int i=0;i<boxTypes.length;i++)
        {
            int num=boxTypes[i][0];
            int units=boxTypes[i][1];
            if(num>=truckSize) {
                res+=truckSize*units;
                break;
            }
            else if(num<truckSize) {
                res+=num*units;
                truckSize-=num;
            }
        }
        return res;
    }
}