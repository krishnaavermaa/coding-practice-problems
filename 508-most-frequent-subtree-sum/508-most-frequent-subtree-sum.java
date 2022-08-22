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
    int mxfreq;
    public int[] findFrequentTreeSum(TreeNode root) {
        mxfreq=0;
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> res=new LinkedList<>();
        recurr(root,map);
        map.forEach((k,v)->{if(v>mxfreq) mxfreq=v;});
        map.forEach((k,v)->{if(v>=mxfreq) res.add(k);});
        return res.stream().mapToInt(i->i).toArray();
    }
    public int recurr(TreeNode root, Map<Integer,Integer> map)
    {
        int left=0,right=0;
        if(root.left!=null) left=recurr(root.left,map);
        if(root.right!=null) right=recurr(root.right,map);
        int ssum=root.val+left+right;
        if(map.get(ssum)!=null) map.put(ssum,map.get(ssum)+1);
        else map.put(ssum,1);
        return ssum;
    }
}