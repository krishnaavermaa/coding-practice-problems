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
    String res;
    public String smallestFromLeaf(TreeNode root) {
        res="";
        recurr(root,"");
        return res;
    }
    public void recurr(TreeNode root,String str)
    {
        str+=String.valueOf((char)(root.val+'a'));
        if(root.left==null && root.right==null)
        {
            String tmp=new StringBuffer(str).reverse().toString();
            int len;
            if(res.equals("")) res=tmp;
            else
            {
                len=str.length()<=res.length()?str.length():res.length();
                int cmp=tmp.substring(0,len).compareTo(res.substring(0,len));
                if(cmp<0 || (cmp==0 && tmp.length()<res.length())) res=tmp;
            }
        }
        if(root.left!=null) recurr(root.left,str);
        if(root.right!=null) recurr(root.right,str);
    }
}