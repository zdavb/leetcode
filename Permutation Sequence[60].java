//构造第K个置换序列
public class Solution {
    int totalNum(int n){
        int num = 1;
        for(int i = 1;i<=n;i++)
            num = num*i;
        return num;
    }
    public String getPermutation(int n, int k) {
        boolean[] numForUse = new boolean[n+1];//all false
        StringBuilder builder = new StringBuilder();
        int total = totalNum(n);
        if(k>total || k<=0)
            return "";
        
        int level = 0;
        while(level < n){
            total = total / (n-level);
            int index = 1;
            //the index for non-use array
            while(k > total){
                k -= total;
                index++;
            }
            int tmpIndex = 1;
            for(int i = 1;i<=n;i++){
                if(numForUse[i])
                    continue;
                if(tmpIndex == index){
                    builder.append(i);
                    numForUse[i] = true;
                    break;
                }
                tmpIndex++;
            }
            level++;
        }
        return builder.toString();
    }
}