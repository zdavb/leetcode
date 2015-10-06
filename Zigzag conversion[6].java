public class Solution {
    public String convert(String s, int numRows) {
        StringBuffer[] buffers = new StringBuffer[numRows];
        for(int i = 0;i<numRows;i++)
            buffers[i] = new StringBuffer();
        
        int len = numRows*2-2;
        if(len == 0)
            return s;
        
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            int index = i%len;
            if(index<numRows)
                buffers[index].append(chars[i]);
            else
                buffers[len-index].append(chars[i]);
        }
        for(int i = 1;i<numRows;i++)
            buffers[0].append(buffers[i]);
        
        return buffers[0].toString();
    }
}