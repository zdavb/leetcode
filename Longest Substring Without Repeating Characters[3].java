public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] schar = s.toCharArray();
        Map<Character,Integer> maps = new HashMap<Character,Integer>();
        int left = 0,right = 0;
        int max = 0;
        
        int length = schar.length;
        while(right<length){
            if(!maps.containsKey(schar[right])){
                maps.put(schar[right],right);
                right++;
            }else{
                int gap = right-left;
                if(gap>max)
                    max = gap;
                int repeatIndex = maps.get(schar[right]);
                while(left<=repeatIndex){
                    maps.remove(schar[left]);
                    left++;
                }
            }
        }
        int gap = right-left;
        if(gap>max)
            max = gap;
        return max;
    }
}