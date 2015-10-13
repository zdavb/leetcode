//思路比较简单，就是先对字符数组排序，然后构成hashmap，重点在于排序。这里采用插入排序
public class Solution {
    private int compare(String s,String tmp){
        char[] chars = s.toCharArray();
        char[] chartmp = tmp.toCharArray();
        
        int sIndex = 0,tmpIndex = 0;
        while(sIndex<chars.length && tmpIndex<chartmp.length){
            if(chars[sIndex] == chartmp[tmpIndex]){
                sIndex++;tmpIndex++;
            }else if(chars[sIndex]<chartmp[tmpIndex])
                return -1;
            else
                return 1;
        }
        if(sIndex < chars.length)
            return 1;
        if(tmpIndex < chartmp.length)
            return -1;
        return 0;
    }
    private void insertIntoList(List<String> list,String s){
        int size = list.size();
        for(int i = 0;i<size;i++){
            String tmp = list.get(i);
            if(compare(s,tmp) < 1){//s < tmp
                list.add(i,s);
                return;
            }
        }
        list.add(s);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> maps = new HashMap<>();
        List<List<String>> res = new LinkedList<>();
        
        for(int i = 0;i<strs.length;i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String news = new String(chars);
            if(!maps.containsKey(news)){
                maps.put(news,new LinkedList<>());
            }
            insertIntoList(maps.get(news),s);
        }
        
        Iterator iter = maps.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            res.add((List)entry.getValue());
        }
        return res;
    }
}


//better one
//Java语言自带了对字符串的排序操作，先进行排序，然后再进行其他操作
public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> maps = new HashMap<>();
        List<List<String>> res = new LinkedList<>();
        Arrays.sort(strs);
        
        for(int i = 0;i<strs.length;i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String news = new String(chars);
            if(!maps.containsKey(news)){
                maps.put(news,new LinkedList<>());
            }
            maps.get(news).add(s);
            //insertIntoList(maps.get(news),s);
        }
        
        Iterator iter = maps.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            res.add((List)entry.getValue());
        }
        return res;
    }