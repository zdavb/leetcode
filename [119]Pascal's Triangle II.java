public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> one = new LinkedList<>();
        List<Integer> two = new LinkedList<>();
        one.add(1);
        
        for(int i = 0;i<rowIndex;i++){
            int prev = 0;
            
            while(one.size()!=0){
                int num = one.remove(0);
                two.add(prev+num);
                prev = num;
            }
            two.add(1);
            
            List<Integer> tmp = one;
            one = two;
            two = tmp;
        }
        return one;
    }
}