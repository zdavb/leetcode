//采用DFS方法
public class Solution {
    int n;
    void dfs(List<String> res,StringBuffer buffer,int total,int left,int remain){//left mean the number of （;remain mean the ( for 匹配
        if(total == n*2){
            res.add(new String(buffer));
            return;
        }
        if(remain == 0){
            buffer.append("(");
            dfs(res,buffer,total+1,left+1,remain+1);
        }else{
            if(left == n){
                buffer.append(')');
                dfs(res,buffer,total+1,left,remain-1);
            }else{
                buffer.append('(');//两种选择，添加(或者)
                dfs(res,buffer,total+1,left+1,remain+1);
                buffer.deleteCharAt(buffer.length()-1);
                buffer.append(')');
                dfs(res,buffer,total+1,left,remain-1);
            }
        }
        buffer.deleteCharAt(buffer.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        List<String> res = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        if(n == 0)
            return res;
        
        dfs(res,buffer,0,0,0);
        return res;
    }
}

//better one
public class Solution {
    private void generate(int leftNum,int rightNum,String s,List<String> list){
        if(leftNum == 0 && rightNum == 0){
            list.add(new String(s));
        }
        if(leftNum>0){
            generate(leftNum-1,rightNum,s+"(",list);
        }        
        if(rightNum>0 && leftNum<rightNum)
            generate(leftNum,rightNum-1,s+")",list);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String s = "";
        generate(n,n,s,res);
        return res;
    }
}