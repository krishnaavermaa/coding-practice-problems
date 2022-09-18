class Solution {
    int res;
    Map<Integer,Integer> map;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        map=new HashMap<>();
        map.put(headID,informTime[headID]);
        res=0;
        for(int i=0;i<n;i++) calcTime(i,manager,informTime);
        return res;
    }
    public int calcTime(int i,int[] manager,int[] informTime)
    {
        if(map.containsKey(i)) return map.get(i);
        int time=informTime[i]+calcTime(manager[i],manager,informTime);
        if(time>res) res=time;
        map.put(i,time);
        return time;
    }
}