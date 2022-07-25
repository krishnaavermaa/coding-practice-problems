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
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> freq=new HashMap<>();
        recurr(root,freq);
        Set<Integer> keys=freq.keySet();
        Iterator it=keys.iterator();
        int max=Integer.MIN_VALUE;
        while(it.hasNext())
        {
            int k=(int)it.next();
            if(freq.get(k)>max) max=freq.get(k);
        }
        System.out.print(max);
        it=keys.iterator();
        List<Integer> list=new LinkedList<>();
        while(it.hasNext())
        {
            int k=(int)it.next();
            if(freq.get(k)==max) list.add(k);
        }
        int arr[]=new int[list.size()];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=list.get(i);
        }
        return arr;
        
    }
    public void recurr(TreeNode node, Map<Integer,Integer> freq)
    {
        int ele=node.val;
        Integer f=freq.get(ele);
        freq.put(node.val,(f!=null)?f+1:1);
        if(node.left!=null) recurr(node.left,freq);
        if(node.right!=null) recurr(node.right,freq);
    }
}