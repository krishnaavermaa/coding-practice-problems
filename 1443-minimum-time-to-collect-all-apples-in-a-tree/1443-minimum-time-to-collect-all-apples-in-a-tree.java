class Solution {
    int visited[];
    List<Integer> list[];
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        visited=new int[n];
        list=new LinkedList[n];
        Arrays.fill(visited,0);
        for(int i=0;i<n;i++) list[i]=new LinkedList<>();
        for(int i=0;i<edges.length;i++)
        {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        int res=visit(0,hasApple);
        if(res>0) res-=2;
        return res;
    }
    public int visit(int indx,List<Boolean> hasApple)
    {
        if(visited[indx]==1) return 0;
        visited[indx]=1;
        int sum=0;
        for(int e:list[indx])
        {
            sum=visit(e,hasApple)+sum;
        }
        if(sum>0 || hasApple.get(indx)) {
            return sum+2;
        }
        else{
            return 0;
        }
    }
}