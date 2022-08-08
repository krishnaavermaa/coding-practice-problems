/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Map<Integer,Node> map=new HashMap<>();
        func(root,map,1);
        return root;
    }
    public void func(Node root,Map<Integer,Node> map, int c)
    {
        if(root.left==null && root.right==null) return;
        if(map.get(c)!=null) map.get(c).next=root.left;
        root.left.next=root.right;
        map.put(c,root.right);
        func(root.left,map,c+1);
        func(root.right,map,c+1);
    }
}