//时间复杂度为O(n)
//维护一个栈结构，对于每个待考察的节点，与栈顶元素的高度，如果低于栈顶高度，那就弹栈，在弹栈的过程中计算弹出的
//节点所占的面积，在谈完之后，将待考察的节点的左边界更新一下，然后存储到stack中
public class Solution {
    class Node{
        int left;
        int right;
        int height;
        
        Node(int left,int right,int height){
            this.left = left;
            this.right = right;
            this.height = height;
        }
        
    }
    public int largestRectangleArea(int[] height) {
        int nums = height.length;
        Node[] nodes = new Node[nums];
        
        for(int i = 0;i<nums;i++)
            nodes[i] = new Node(i,i+1,height[i]);
            
        Stack<Node> stack = new Stack<>();
        int max = 0;
        
        for(int i = 0;i<nums;i++){
            int newLeft = -1;
            while(!stack.isEmpty()){
                Node top = stack.peek();
                if(top.height < nodes[i].height){
                    break;
                }
                stack.pop();//出栈
                int area = (nodes[i].left - top.left)*(top.height);
                newLeft = top.left;
                
                if(area > max)
                    max = area;
            }   
            if(newLeft != -1)
                nodes[i].left = newLeft;
                
            stack.push(nodes[i]);
        }
        //deal with the remain node
        int right = -1;
        while(!stack.isEmpty()){
            Node top = stack.pop();
            if(right == -1)
                right = top.right;
            int area = top.height * (right - top.left);
            if(area > max)
                max = area;
        }
        return max;
    }
}

//more elegant
//核心思路是一样的，只是在后面添加一个0，来保证了当循环结束时，栈一定为空。
//此外，通过让新入的节点的右边界来参与判断，可以解放左边界。
public class Solution {
    class Node{
        int left;
        int right;
        int val;
        
        Node(int left,int right,int val){
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
    public int largestRectangleArea(int[] height) {
        int length = height.length;
        Node[] nodes = new Node[length+1];
        
        for(int i = 0;i<length;i++){
            nodes[i] = new Node(i,i+1,height[i]);
        }
        nodes[length] = new Node(length,length+1,0);
        
        Stack<Node> stack = new Stack<>();
        int max = 0;
        
        for(int i = 0;i<length+1;i++){
            Node curNode = nodes[i];
            
            while(!stack.isEmpty()){
                Node top = stack.peek();
                if(top.val < curNode.val)
                    break;
                stack.pop();
                int area = (curNode.right - top.left - 1)*top.val;
                if(area > max)
                    max = area;
                curNode.left = top.left;
            }
            stack.push(curNode);
        }
        return max;
    }
}