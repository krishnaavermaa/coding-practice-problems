class Solution {
    int[] visited;
    List<Integer> []list;
    int ans[];
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        visited=new int[n];
        list=new LinkedList[n];
        ans=new int[n];
        for(int i=0;i<n;i++){
            visited[i]=0;
            ans[i]=0;
            list[i]=new LinkedList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        visit(0,labels);
        return ans;
    }
    public int[] visit(int indx,String labels)
    {
        visited[indx]=1;
        int freq[]=new int[26];
        Arrays.fill(freq,0);
        freq[labels.charAt(indx)-'a']+=1;
        for(int ele:list[indx])
        {
            if(visited[ele]!=1) 
            {
                int tmp[]=new int[26];
                tmp=visit(ele,labels);
                for(int i=0;i<26;i++) freq[i]+=tmp[i];
            }
        }
        ans[indx]=freq[labels.charAt(indx)-'a'];
        return freq;
    }
}