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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        if(root1!=null) recurr(root1,map);
        if(root2!=null) recurr(root2,map);
        Iterator it=map.keySet().iterator();
        while(it.hasNext())
        {
            int key=(Integer)it.next();
            int c=map.get(key);
            while(c--!=0) res.add(key);
        }
        return res;
    }
    public void recurr(TreeNode root, Map<Integer,Integer> map)
    {
        if(map.containsKey(root.val)) map.put(root.val,map.get(root.val)+1);
        else map.put(root.val,Integer.valueOf(1));
        if(root.left!=null) recurr(root.left,map);
        if(root.right!=null) recurr(root.right,map);
    }
}