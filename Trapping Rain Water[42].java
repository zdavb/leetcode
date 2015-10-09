/*
    维护一个栈，当新入元素小于栈顶中元素的高度时，入栈
    反之，出栈，在出栈的时候，元素的高度-之前元素高度，然后乘以之前元素的宽度即为一部分面积
    同时，更新之前元素的左边和高度

*/
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
    public int trap(int[] height) {
        Stack<Node> stack = new Stack<>();
        int count = 0;
        for(int i = 0;i<height.length;i++){
            if(stack.isEmpty()){
                stack.push(new Node(i,i+1,height[i]));
            }else{
                Node top = stack.peek();
                if(top.val>height[i])
                    stack.push(new Node(i,i+1,height[i]));
                else{
                    Node prev = stack.pop();
                    while(!stack.isEmpty()){
                        Node intop = stack.peek();
                        if(intop.val>height[i]){
                            count+=(height[i]-prev.val)*(prev.right-prev.left);
                            break;
                        }
                        count+=(intop.val-prev.val)*(prev.right-prev.left);
                        prev.left = intop.left;
                        prev.val = intop.val;
                        stack.pop();
                    }
                    stack.push(new Node(prev.left,i+1,height[i]));
                }
            }
        }
        return count;
    }
} 

//better one
//非常好的idea
/*思想：先找到最高点和对应的坐标。从图中可以看出，当找到最高点后，从两端到最高点的过程中，
水平面的高度是逐渐升高的。而且高度的提升是由于某个坐标高于当前水平面，所以导致提高。
而且提高之后，该高度值保持不变，此时高度-当前坐标高度值，即为蓄水高度，因为宽度为1，蓄水量即为高度值
*/
public class Solution {
    public int trap(int[] height) {
        if(height.length<2)
            return 0;
        int max = height[0];
        int maxIndex = 0;
        //find the top point
        for(int i = 1;i<height.length;i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }
        int area = 0;
        int rootval = height[0];
        for(int i = 1;i<maxIndex;i++){
            if(height[i]>rootval) rootval = height[i];
            else{
                area+=rootval-height[i];
            }
        }
        rootval = height[height.length-1];
        for(int i = height.length-2;i>maxIndex;i--){
            if(height[i]>rootval) rootval = height[i];
            else{
                area+=rootval-height[i];
            }
        }
        return area;
    }
}
//another better one
/*思想是：对于每个点而言，它的高度只有两个决定因素，即它的左部分的最高值和右部分的最高值的最小值。
    这样累计起来即可
*/
public class Solution {
    public int trap(int[] height) {
        if(height.length<=2)
            return 0;
            
        int[] maxleft = new int[height.length];
        int[] maxright = new int[height.length];
        
        //init maxleft
        int maxleftVal = height[0];
        for(int i = 1;i<height.length;i++){
            if(height[i-1]>maxleftVal)
                maxleftVal = height[i-1];
            maxleft[i] = maxleftVal;
        }
        //init maxright
        int maxrightVal = height[height.length-1];
        for(int i = height.length-2;i>=0;i--){
            if(height[i]>maxrightVal)
                maxrightVal = height[i];
            maxright[i] = maxrightVal;
        }
        
        int sum = 0;
        for(int i = 1;i<height.length-1;i++){
            int h = Math.min(maxleft[i],maxright[i]);
            sum+=Math.max(h-height[i],0);
        }
        return sum;
    }
}