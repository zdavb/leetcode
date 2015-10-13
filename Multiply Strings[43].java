//该方法巧妙解决了乘法错位的问题
//核心思想是：开辟一个新的len1+len2长的数组，每次乘积操作都在该数组中进行。
//当对char1[i]与char1[j]操作时，影响的数组位置为res[i+j+1]
//为啥要+1呢？主要是如果不加1，那么当char1[0]与char2[0]如果产生进位，则无所适从
public class Solution {
    public String multiply(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] res = new int[char1.length+char2.length];

        for(int i = char1.length-1;i>=0;i--){
            int int1 = char1[i] - '0';
            for(int j = char2.length-1;j>=0;j--){
                int int2 = char2[j] - '0';
                
                int total = res[i+j+1]+int1*int2;
                if(total>=10){
                    res[i+j] += total/10;
                    total%= 10;
                }
                res[i+j+1] = total;
            }
        }
        //过滤前排0
        int index = 0;
        boolean isValid = false;
        StringBuilder builder = new StringBuilder();
        
        for(index = 0;index<res.length;index++){
            if(res[index] != 0)
                isValid = true;
            if(isValid){
                builder.append(res[index]);
            }
        }
        if(!isValid)
            return "0";
        return builder.toString();
    }
}