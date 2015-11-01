public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        char[] char1 = a.toCharArray();
        char[] char2 = b.toCharArray();
        
        int index1 = char1.length-1;
        int index2 = char2.length-1;
        
        int prev = 0;
        while(index1>=0 && index2>=0){
            int val1 = char1[index1]-'0';
            int val2 = char2[index2]-'0';
            
            int total = val1+val2+prev;
            builder.append(total % 2);
            prev = total / 2;
            
            index1--;index2--;
        }
        while(index1>=0){
            int total = char1[index1]-'0'+prev;
            builder.append(total % 2);
            prev = total / 2;
            index1--;
        }
        while(index2 >= 0){
            int total = char2[index2]-'0'+prev;
            builder.append(total % 2);
            prev = total/2;
            index2--;
        }
        if(prev>0)
            builder.append(1);
        builder = builder.reverse();
        return builder.toString();
    }
}