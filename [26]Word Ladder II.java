//遍历set集合，TLE
public class Solution {
    String beginWord;
    String endWord;
    List<List<String>> res;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        res = new LinkedList<>();
        List<String> tmplist = new LinkedList<>();
        tmplist.add(beginWord);
        
        this.beginWord = beginWord;
        this.endWord = endWord;
        
        dfs(tmplist,wordList);
        return res;
    }
    void dfs(List<String> tmplist,Set<String> wordList){
        int size = tmplist.size();
        String lastStr = tmplist.get(size-1);
        if(distance(lastStr,endWord) == 1){
            List<String> inner = new LinkedList<>();
            inner.add(endWord);
            res.add(inner);
            return;
        }
        Iterator<String> iterator = wordList.iterator();
        while(iterator.hasNext()){
            String nextStr = iterator.next();
            if(distance(lastStr,nextStr) == 1){
                tmplist.add(nextStr);
                Set<String> tmpset = new HashSet<>(wordList);
                tmpset.remove(nextStr);
                
                dfs(tmplist,tmpset);
                tmplist.remove(tmplist.size()-1);
            }
        }
    }
    int distance(String word1,String word2){
        int distance = 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        
        int length = chars1.length;
        for(int i = 0;i<length;i++){
            if(chars1[i] != chars2[i])
                distance++;
            if(distance > 1)
                break;
        }
        return distance;
    }
}