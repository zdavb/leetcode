public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevlist = new LinkedList<>();
        List<Integer> nextlist = new LinkedList<>();
        prevlist.add(0);
        
        int size = triangle.size();
        for(int i = 0;i<size;i++){
            List<Integer> tmplist = triangle.get(i);
            int tmpsize = tmplist.size();
            
            for(int j = 0;j<tmpsize;j++){
                int value = tmplist.get(j);
                int upLeftIndex = j-1;
                int upRightIndex = j;
                
                int minValue = Integer.MAX_VALUE;
                if(upLeftIndex>=0){
                    int tmpVal = value + prevlist.get(upLeftIndex);
                    if(tmpVal < minValue)
                        minValue = tmpVal; 
                }
                if(upRightIndex < prevlist.size()){
                    int tmpVal = value + prevlist.get(upRightIndex);
                    if(tmpVal < minValue)
                        minValue = tmpVal;
                }
                nextlist.add(minValue);
            }
            List<Integer> tmpPrevList = prevlist;
            prevlist = nextlist;
            nextlist = tmpPrevList;
            nextlist.clear();
        }
        
        int minSum = Integer.MAX_VALUE;
        for(int i = 0;i<size;i++){
            int value = prevlist.get(i);
            if(value < minSum)
                minSum = value;
        }
        return minSum;
    }
}