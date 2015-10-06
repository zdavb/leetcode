public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        Map<Character,String> maps = new HashMap<>();
        String[] strs = str.split(" ");
        
        if(patterns.length != strs.length)
            return false;
        
        for(int i = 0;i<patterns.length;i++){
            char ch = patterns[i];
            if(maps.containsKey(ch)){
                String value = maps.get(ch);
                if(!value.equals(strs[i]))
                    return false;
            }else{
                if(maps.containsValue(strs[i]))
                    return false;
                maps.put(ch,strs[i]);
            }
        }
        return true;
    }
}