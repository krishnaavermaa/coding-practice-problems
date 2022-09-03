/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,TreeMap<Integer,LinkedList<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map=new TreeMap<>();
        recurr(root,0,0);
        List<List<Integer>> res=new LinkedList<>();
        Iterator<Map.Entry<Integer,TreeMap<Integer,LinkedList<Integer>>>> it=map.entrySet().iterator();
        while(it.hasNext())
        {
            Iterator<Map.Entry<Integer,LinkedList<Integer>>> it2=(it.next().getValue()).entrySet().iterator();
            LinkedList<Integer> list=new LinkedList<>();
            while(it2.hasNext()) list.addAll(it2.next().getValue());
            res.add(list);
        }
        return res;
    }
    public void recurr(TreeNode root,int lev,int order)
    {
        TreeMap<Integer,LinkedList<Integer>> lhm;
        if(!map.containsKey(order))
        {
            LinkedList<Integer> tmp=new LinkedList<>();
            tmp.add(root.val);
            lhm=new TreeMap<>();
            lhm.put(lev,tmp);
            map.put(order,lhm);
        }
        else
        {
            lhm=map.get(order);
            LinkedList<Integer> tmp;
            if(!lhm.containsKey(lev)) {
                tmp=new LinkedList<>();
                tmp.add(root.val);
                lhm.put(lev,tmp);
            }
            else{
                tmp=lhm.get(lev);
                int i=0;
                for(int e:tmp)
                {
                    if(root.val>e) i++;
                    else break;
                }
                tmp.add(i,root.val);
                lhm.put(lev,tmp);
            }
            map.put(order,lhm);
        }
        if(root.left!=null) recurr(root.left,lev+1,order-1);
        if(root.right!=null) recurr(root.right,lev+1,order+1);
    }
}