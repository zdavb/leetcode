public class Solution {
    Set<String> sets;
    String s;
    List<String> res;
    int length;
    public List<String> restoreIpAddresses(String s) {
        sets = new HashSet();
        res = new LinkedList<>();
        List<Integer> indexlist = new LinkedList<>();
        this.s = s;
        length = s.length();
        
        dfs(0,indexlist);
    
        return res;
    }
    private void dfs(int base,List<Integer> indexlist){
        if(base >= length)
            return;
        if(indexlist.size() == 3){//3个点
            String ss = s.substring(base);
            if(isValid(ss)){
                StringBuilder builder = new StringBuilder();
                int prevIndex = 0;
                for(int index:indexlist){
                    String tmp = s.substring(prevIndex,index);
                    builder.append(tmp);
                    builder.append('.');
                    prevIndex = index;
                }
                builder.append(ss);
                
                String value = builder.toString();
                if(!sets.contains(value)){
                    res.add(value);
                    sets.add(value);
                }
            }
            return;
        }
        
        for(int i = 0;i<3;i++){
            int endIndex = (base+i+1) > length ? length:(base+i+1);
            
            String ss = s.substring(base,endIndex);
            if(!isValid(ss))
                break;
            
            indexlist.add(endIndex);
            dfs(endIndex,indexlist);
            indexlist.remove(indexlist.size()-1);
        }
    }
    private boolean isValid(String s){
        int length = s.length();
        if(length > 3)
            return false;
            
        int value = Integer.parseInt(s);
        
        switch(length){
            case 1:
                if(value>=0 && value <10)
                    return true;
                break;
            case 2:
                if(value >=10 && value <100)
                    return true;
                break;
            case 3:
                if(value >=100 && value <=255)
                    return true;
                break;    
        }
        return false;
    }
}