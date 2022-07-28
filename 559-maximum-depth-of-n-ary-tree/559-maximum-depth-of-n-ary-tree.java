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
    public int maxDepth(Node root) {
        if(root==null) return 0;
        if(root.children.isEmpty()) return 1;
        int g=0,tmp;
        for(int i=0;i<root.children.size();i++)
        {
            tmp=maxDepth(root.children.get(i));
            if(tmp>g) g=tmp;
        }
        return g+1;
    }
}