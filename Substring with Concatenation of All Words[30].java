public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int length = s.length();
        int sizeOfWord = words[0].length();
        int numOfWord = words.length;
        List<Integer> res = new ArrayList<>();
        HashMap<String,Integer> originmap = new HashMap<>();
        
        //init map
        for(int i = 0;i<words.length;i++){
            if(!originmap.containsKey(words[i]))
                originmap.put(words[i],0);
            originmap.replace(words[i],originmap.get(words[i])+1);
        }
        
        for(int i = 0;i<sizeOfWord;i++){
            int left = i;
            int right = i+sizeOfWord;
            HashMap<String,Integer> maps = new HashMap<>(originmap);
            int count = 0;
            for(;right<=length;right+=sizeOfWord){
                String substr =s.substring(right-sizeOfWord,right);
                if(!maps.containsKey(substr)){
                    left = right;
                    count = 0;
                    maps = new HashMap<>(originmap);
                    continue;
                }
                int num = maps.get(substr)-1;
                count++;
                maps.put(substr,num);
                
                if(num<0){//存在重复字符串
                    while(left<right){
                        String subsubstr = s.substring(left,left+sizeOfWord);
                        int numnum = maps.get(subsubstr)+1;
                        count--;
                        maps.put(subsubstr,numnum);
                        left+=sizeOfWord;
                        
                        if(numnum==0)//退出循环
                            break;
                    }
                }
                if(count == numOfWord){
                    res.add(left);
                    String subsubstr = s.substring(left,left+sizeOfWord);
                    maps.put(subsubstr,1);
                    count--;
                    left += sizeOfWord;
                }
            }
        }
        return res;
    }
}