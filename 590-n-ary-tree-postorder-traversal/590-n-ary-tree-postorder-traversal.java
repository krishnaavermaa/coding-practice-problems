/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list=new LinkedList<>();
        if(root==null) return list;
        recurr(root,list);
        return list;
    }
    public void recurr(Node node, List<Integer> list)
    {
        if(!node.children.isEmpty())
            for(int i=0;i<node.children.size();i++)
                recurr(node.children.get(i),list);
        list.add(node.val);
    }
}