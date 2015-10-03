//O(n2)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left,right;
        int length = nums.length;
        for(left = 0;left<length;left++){
            for(right = left+1;right<length;right++){
                if(nums[left]+nums[right] == target)
                    return new int[]{left+1,right+1};
            }
        }
        return new int[]{1,1};
    }
}
//O(nlogn)
public class Solution {
    class Node{
        int val;
        int index;
        Node(int val,int index){
            this.val = val;
            this.index = index;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Node[] nodes = new Node[length];
        for(int i = 0;i<length;i++)
            nodes[i] = new Node(nums[i],i);
        
        Arrays.sort(nodes,new Comparator<Node>(){
            public int compare(Node o1,Node o2){
                return o1.val-o2.val;
            }  
        });
        int left = 0,right = nodes.length-1;
        while(left<right){
            int val = nodes[left].val+nodes[right].val;
            if(val == target)
                break;
            else if(val > target)
                --right;
            else
                ++left;
        }
        int leftIndex = nodes[left].index;
        int rightIndex = nodes[right].index;
        
        if(leftIndex<rightIndex)
            return new int[]{leftIndex+1,rightIndex+1};
        else
            return new int[]{rightIndex+1,leftIndex+1};
    }
}
//O(N)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> maps = new HashSet<>();
        for(int i = 0;i<nums.length;i++)
            maps.add(nums[i]);
        
        int left = 0,right = 0;
        for(left = 0;left<nums.length;left++){
            int needVal = target-nums[left];
            if(maps.contains(needVal)){
                for(right = left+1;right<nums.length;right++)
                    if(nums[right] == needVal)
                        break;
                if(right<nums.length)        
                    break;
            }
        }
        return new int[]{left+1,right+1};
    }
}