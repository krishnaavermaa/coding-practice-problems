class Solution {
    int []ans;
    int visited[];
    List<Integer> []list;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans=new int[n];
        visited=new int[n];
        list=new LinkedList[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=0;
            visited[i]=0;
            list[i]=new LinkedList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        countNodes(0,labels);
        return ans;
    }
    public Map<Character,Integer> countNodes(int indx,String labels)
    {
        Map<Character,Integer> map=new HashMap<>();
        visited[indx]=1;
        for(int e:list[indx])
        {
            Map<Character,Integer> tmp=new HashMap<>();
            if(visited[e]==0) tmp=countNodes(e,labels);
            Iterator<Map.Entry<Character,Integer>> it=tmp.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry<Character,Integer> es=it.next();
                if(map.containsKey(es.getKey())) map.put(es.getKey(),map.get(es.getKey())+es.getValue());
                else map.put(es.getKey(),es.getValue());
            }
        }
        if(list[indx].size()==0 || (list[indx].size()==1 && indx!=0))
        {
            map.put(labels.charAt(indx),1);
        }
        else {
            if(map.containsKey(labels.charAt(indx))) map.put(labels.charAt(indx),map.get(labels.charAt(indx))+1);
            else map.put(labels.charAt(indx),1);
        }
        ans[indx]=map.get(labels.charAt(indx));
        return map;
    }
}