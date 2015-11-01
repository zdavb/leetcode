//思路：
//使用快慢指针，当快指针找全了全部的字符后，慢指针随后根据，压缩字符串。
public class Solution {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        
        HashMap<Character,Integer> maps = new HashMap<>();
        
        //init hashmap
        for(int i = 0;i<chart.length;i++){
            char ch = chart[i];
            if(!maps.containsKey(ch))
                maps.put(ch,0);
            maps.replace(ch,maps.get(ch)+1);
        }
        int needCount = maps.size();
        
        int fast = 0;
        int slow = 0;
        
        int min = Integer.MAX_VALUE;
        int minleft = -1;
        int minright = 0;
        
        while(fast < chars.length){
            if(maps.containsKey(chars[fast])){
                int count = maps.get(chars[fast])-1;
                maps.replace(chars[fast],count);
                
                if(count == 0)
                    needCount--;
                
                if(needCount == 0){//got all value
                    //移动左指针
                   while(slow < fast){
                       if(maps.containsKey(chars[slow])){
                           int slowCount = maps.get(chars[slow]);
                           maps.replace(chars[slow],slowCount+1);
                           if(slowCount == 0)
                                break;
                       }
                       slow++;
                   }
                   int gap = fast - slow + 1;
                   if(gap < min){
                       min = gap;
                       minleft = slow;
                       minright = fast+1;
                   }
                   slow++;needCount++;
                }
            }
            fast++;
        }
        if(min == Integer.MAX_VALUE)
            return "";
        
        return s.substring(minleft,minright);
    }
}