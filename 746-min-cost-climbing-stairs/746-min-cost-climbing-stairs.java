class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int mem[]=new int[cost.length];
        int zeroStarting=0;
        int oneStarting=0;
        Arrays.fill(mem,-1);
        
        if(mem[0]==-1){
            zeroStarting=cost(cost,0,mem);
        }
        else zeroStarting=mem[0];
        if(mem[1]==-1){
            oneStarting=cost(cost,1,mem);
        }
        else oneStarting=mem[1];
        return zeroStarting<=oneStarting?zeroStarting:oneStarting;
    }
    public int cost(int []cost,int index,int mem[])
    {
        if(index>=cost.length){
            return 0;
        }
        if(mem[index]==-1){
            int leftc=cost[index]+cost(cost,index+1,mem);
            int rightc=cost[index]+cost(cost,index+2,mem);
            mem[index]=rightc<=leftc?rightc:leftc;
        }
        return mem[index];
    }
}