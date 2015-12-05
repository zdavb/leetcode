//TLE版本，直接递归搜索
public class Solution {
    int nums = 0;
    int length;
    
    public int numDecodings(String s) {
        length = s.length();
        findLengthOfString(s,0);
        return length;
    }
    public void findLengthOfString(String s,int index){
        if(index >= length)//go to the end
        {
            nums++;
            return;
        }
        char ch1 = s.charAt(index);
        char ch2 = index+1<length ? s.charAt(index+1) : 'A';//if over the array boundary,ch2 will be an invalid number;
        
        findLengthOfString(s,index+1);
        int val = (ch1 - '0')*10+(ch2 - '0');
        if(val >= 10 && val <=26)
            findLengthOfString(s,index+2);
    }
}

//DP算法
public class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if(length <= 0)
            return 0;
            
        int[] nums = new int[length];
        
        nums[0] = (chars[0] == '0')?0:1;
        
        for(int i = 1;i<length;i++){
            if(chars[i] != '0')
                nums[i]+=nums[i-1];
            
            int val = (chars[i-1]-'0')*10 + chars[i]-'0';
            if(val >= 10 && val <=26){
                nums[i] += (i>1)?nums[i-2]:1;
            }
        }
        return nums[length-1];
    }
}