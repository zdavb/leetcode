public class Solution {
    private boolean isOk(char top,char ch){
        if(top == '[' && ch == ']')
            return true;
        if(top == '{' && ch == '}')
            return true;
        if(top == '(' && ch == ')')
            return true;
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        for(int i = 0;i<chars.length;i++){
            char ch = chars[i];
            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else{
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(!isOk(top,ch))
                    return false;
            }
        }
        return stack.size() == 0;
    }
}