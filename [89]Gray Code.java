//格雷码的特点是，每次在左侧添加新的1时，新添加的右侧部分与之前的序列正好是逆序。
//利用这个特点可以快速找到所有的序列。
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        
        for(int i = 0;i<n;i++){
            int size = list.size();
            int nextBase = 1<<i;
            for(int j = size-1;j>=0;j--){
                list.add(list.get(j)+nextBase);
            }
        }
        return list;
    }
}