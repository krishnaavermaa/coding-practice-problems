class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> prevRow= new ArrayList<>(List.of(1));
        result.add(prevRow);
        for(int i=1;i<numRows;i++){
            prevRow=calcRow(i,prevRow);
            result.add(prevRow);
        }
        return result;
    }
    private List<Integer> calcRow(int row, List<Integer> prevRow){
        List<Integer> rowRes=new ArrayList<>();
        for(int i=0;i<=row;i++){
            int sum=0;
            if(i-1>=0) sum+=prevRow.get(i-1);
            if(i<prevRow.size()) sum+=prevRow.get(i);
            rowRes.add(sum);
        }
        return rowRes;
    }
}