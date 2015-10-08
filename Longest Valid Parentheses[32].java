//时间复杂度为O(n)
//空间复杂度为O(n)
//思想是：维护两个栈，第一个栈维护'('字符，第二个栈维护一个到当前字符为止，已经匹配了的字符，
//当然对于中间存在间隔的比如(或者)，将起到隔断作用
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        int res = 0;
        char[] chars = s.toCharArray();
        
        for(int i = 0;i<chars.length;i++){
            char ch = chars[i];
            if(ch == ')'){
                if(charStack.isEmpty()){
                    intStack.push(-1);
                }else{
                    charStack.pop();
                    int count = 0;
                    while(!intStack.isEmpty()){
                        int val = intStack.pop();
                        if(val == 1){//（
                            count+=2;
                            break;
                        }
                        count+=val;
                    }
                    intStack.push(count);
                }
                
            }else{
                charStack.push('(');
                intStack.push(1);
            }
        }
        int count = 0;
        while(!intStack.isEmpty()){
            int val = intStack.pop();
            if(val == -1||val == 1){
                if(count>res)
                    res = count;
                count = 0;
            }else{
                count+=val;
            }
        }
        return Math.max(res,count);
    }
}

//better one
//思路：维护一个相同大小的Boolean数组，并维护一个栈，栈中标注到当前为止所有待匹配的'('的index
//当新的字符为(时，向栈中添加一个新的index。当新的字符为)时，从栈中弹出index，并且在该index处的Boolean数组标注为true
//表示已经可以被匹配了
//当遍历结束之后，Boolean数组中为false的点，相当于一个隔断，表示没有与该点进行匹配的。
public class Solution {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        boolean[] bools = new boolean[chars.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;i<chars.length;i++){
            char ch = chars[i];
            if(ch == '('){
                stack.push(i);
            }else if(!stack.isEmpty()){
                bools[stack.pop()] = true;
                bools[i] = true;
            }
        }
        
        int res = 0;
        int count = 0;
        for(int i = 0;i<bools.length;i++){
            if(bools[i]) count++;
            else{
                res = Math.max(res,count);
                count = 0;
            }
        }
        return Math.max(res,count);
    }
}