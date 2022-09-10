class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Stack<Integer> stack=new Stack<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(i);
        for(int i:leftChild)
            set.remove(i);
        for(int i:rightChild)
            set.remove(i);
        if(set.size()!=1) return false;
        stack.push(set.iterator().next());
        set.clear();
        while(!stack.isEmpty())
        {
            int i=stack.pop();
            if(!set.contains(i)) set.add(i);
            else return false;
            if(rightChild[i]!=-1) stack.push(rightChild[i]);
            if(leftChild[i]!=-1) stack.push(leftChild[i]);
        }
        if(set.size()!=n) return false;
        return true;
    }
}