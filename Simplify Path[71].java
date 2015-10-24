public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        List<String> res = new LinkedList<>();
        
        for(int i = 0;i<strs.length;i++){
            if(strs[i].length() == 0 || strs[i].equals("."))
                continue;
            else if(strs[i].equals("..")){
                int size = res.size();
                if(size > 0)
                    res.remove(size-1);
            }
            else
                res.add(strs[i]);
        }
        //reconstruct res
        StringBuilder builder = new StringBuilder();
        int size = res.size();
        for(int i = 0;i<size;i++){
            builder.append('/');
            builder.append(res.get(i));
        }
        return builder.length() == 0 ? "/":builder.toString();
    }
}