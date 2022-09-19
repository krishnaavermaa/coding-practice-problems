class Solution {
    int visited[];
    Map<Integer,LinkedList<Integer>> map;
    boolean end;
    double res;
    boolean isAloneTarget;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(edges.length==0) return 1.0;
        end=false;
        isAloneTarget=false;
        visited=new int[n+1];
        Arrays.fill(visited,0);
        res=1.0;
        map=new HashMap<>();
        for(int i=0;i<edges.length;i++)
        {
            LinkedList<Integer> tmp;
            if(map.containsKey(edges[i][0])) tmp=map.get(edges[i][0]);
            else tmp=new LinkedList();
            tmp.add(edges[i][1]);
            map.put(edges[i][0],tmp);
            if(map.containsKey(edges[i][1])) tmp=map.get(edges[i][1]);
            else tmp=new LinkedList<>();
            tmp.add(edges[i][0]);
            map.put(edges[i][1],tmp);
        }
        if(map.get(target).size()==1) isAloneTarget=true;
        if(!visit(target,edges,t,target)) return 0.0;
        return res;
    }
    public boolean visit(int indx,int [][]edges,int t,int target)
    {
        if(t<0 || visited[indx]==1 || end) return false;
        visited[indx]=1;
        
        if(indx==1){
            if(t==0 || (isAloneTarget && target!=1)) return true;
            res=0.0;
            end=true;
            return false;
        }

        for(int e:map.get(indx))
        {
            if(visit(e,edges,t-1,target))
            {
                if(e==1) res/=(double)(map.get(e).size());
                else res/=(map.get(e).size()-1)!=0?(double)(map.get(e).size()-1):1;
                return true;
            }
        }
        return false;
    }
}