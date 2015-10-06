//使用递归的方法
public class Solution {
    private String convertCharToStr(char ch){
        switch(ch){
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        return "";
    }
    private void rescombination(List<String> res,String[] strs,StringBuffer buffer,int index){
        if(index == strs.length){
            res.add(new String(buffer));
            return;
        }
        for(int i = 0;i<strs[index].length();i++){
            buffer.append(strs[index].charAt(i));
            rescombination(res,strs,buffer,index+1);
            buffer.deleteCharAt(buffer.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        StringBuffer buffer = new StringBuffer();
        List<String> res = new ArrayList<>();
        String[] strs = new String[chars.length];
         
        if(chars.length == 0)
            return res;
        
        for(int i = 0;i<chars.length;i++){
            strs[i] = convertCharToStr(chars[i]);
        }
        
        rescombination(res,strs,buffer,0);
        return res;
    }
}