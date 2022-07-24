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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head=new TreeNode(nums[0]);
        HashMap<TreeNode,Integer> height=new HashMap<>();
        height.put(head,1);
        int lh=0,rh=0,bf=0;
        for(int i=1;i<nums.length;i++)
        {
            insert(head,nums[i],height);
            lh=(head.left!=null)?height.get(head.left):0;
            rh=(head.right!=null)?height.get(head.right):0;
            bf=lh-rh;
            if(bf<=1 && bf>=-1) height.put(head,(lh>=rh)?lh+1:rh+1);
            else
            {
//                 if(bf>0)
//                 {
                    
//                     if(nums[i]<head.left.val) LLRotate(head, height);
//                     else if(nums[i]>head.left.val) LRRotate(head, height);
//                 }
//                 else if(bf<0)
//                 {
//                     if(nums[i]>head.right.val) 
                        RRRotate(head, height);
//                     else if(nums[i]<head.right.val) RLRotate(head, height);
//                 }
            }
        }
        return head;
    }
    public void insert(TreeNode ptr,int ele, HashMap<TreeNode,Integer> height)
    {
        int lh=0,rh=0,bf=0;
        TreeNode L=ptr.left,R=ptr.right;
        if(ele<ptr.val)
        {
            if(L!=null) insert(L,ele,height);
            else {
                ptr.left=new TreeNode(ele);
                L=ptr.left;
                height.put(L,1);
                // lh=1;
            }
        }
        else if(ele>ptr.val)
        {
            if(R!=null) insert(R,ele,height);
            else{
                ptr.right=new TreeNode(ele);
                R=ptr.right;
                height.put(R,1);
                // rh=1;
            }
        }
        lh=(ptr.left!=null)?height.get(ptr.left):0;
        rh=(ptr.right!=null)?height.get(ptr.right):0;
        bf=lh-rh;
        if(bf<=1 && bf>=-1) height.put(ptr,(lh>=rh)?lh+1:rh+1);
        else
        {
//             if(bf>0)
//             {

//                 if(ele<L.val) LLRotate(ptr, height);
//                 else if(ele>L.val) LRRotate(ptr, height);
//             }
//             else if(bf<0)
//             {
//                 if(ele>R.val) 
                    RRRotate(ptr,height);
//                 else if(ele<R.val) RLRotate(ptr, height);
//             }
        }
    }
//     public void LLRotate(TreeNode ptr,HashMap<TreeNode,Integer> height)
//     {
//         TreeNode tmp=new TreeNode(ptr.val);
//         tmp.right=ptr.right;
//         ptr.right=tmp;
//         ptr.val=ptr.left.val;
//         tmp=ptr.left.right;
//         ptr.left=ptr.left.left;
//         ptr.right.left=tmp;
        
//         int lh=(ptr.right.left!=null)?height.get(ptr.right.left):0;
//         int rh=(ptr.right.right!=null)?height.get(ptr.right.right):0;
//         height.put(ptr.right,(lh>=rh)?lh+1:rh+1);
        
//         lh=height.get(ptr.left);
//         rh=height.get(ptr.right);
//         height.put(ptr,(lh>=rh)?lh+1:rh+1);
//     }
    public void RRRotate(TreeNode ptr,HashMap<TreeNode,Integer> height)
    {
        TreeNode tmp=new TreeNode(ptr.val);
        tmp.left=ptr.left;
        ptr.left=tmp;
        ptr.val=ptr.right.val;
        tmp=ptr.right.left;
        height.remove(ptr.right);
        ptr.right=ptr.right.right;
        ptr.left.right=tmp;
        
        int lh=ptr.left.left!=null?height.get(ptr.left.left):0;
        int rh=ptr.left.right!=null?height.get(ptr.left.right):0;
        height.put(ptr.left,(lh>=rh)?lh+1:rh+1);
        
        lh=ptr.left!=null?height.get(ptr.left):0;
        rh=ptr.right!=null?height.get(ptr.right):0;
        height.put(ptr,(lh>=rh)?lh+1:rh+1);
    }
//     public void LRRotate(TreeNode ptr,HashMap<TreeNode,Integer> height)
//     {
//         TreeNode tmp=new TreeNode(ptr.val);
//         tmp.right=ptr.right;
//         tmp.left=ptr.left.right.right;
//         ptr.right=tmp;
//         ptr.val=ptr.left.right.val;
//         ptr.left.right=ptr.left.right.left;
        
//         int lh=ptr.right.left!=null?height.get(ptr.right.left):0;
//         int rh=ptr.right.right!=null?height.get(ptr.right.right):0;
//         height.put(ptr.right,(lh>=rh)?lh+1:rh+1);
        
//         lh=ptr.left!=null?height.get(ptr.left):0;
//         rh=ptr.right!=null?height.get(ptr.right):0;
//         height.put(ptr,(lh>=rh)?lh+1:rh+1);
//     }
//     public void RLRotate(TreeNode ptr,HashMap<TreeNode,Integer> height)
//     {
//         TreeNode tmp=new TreeNode(ptr.val);
//         tmp.left=ptr.left;
//         tmp.right=ptr.right.left.left;
//         ptr.left=tmp;
//         ptr.val=ptr.right.left.val;
//         ptr.right.left=ptr.right.left.right;
        
//         int lh=ptr.left.left!=null?height.get(ptr.left.left):0;
//         int rh=ptr.left.right!=null?height.get(ptr.left.right):0;
//         height.put(ptr.left,(lh>=rh)?lh+1:rh+1);
        
//         lh=ptr.left!=null?height.get(ptr.left):0;
//         rh=ptr.right!=null?height.get(ptr.right):0;
//         height.put(ptr,(lh>=rh)?lh+1:rh+1);
//     }
    
    
}