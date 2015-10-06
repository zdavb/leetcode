//时间复杂度：O(n3)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> sets = new HashSet<>();
        
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum<target)
                        left++;
                    else if(sum>target)
                        right--;
                    else{
                        if(!sets.contains(nums[i]+"&"+nums[j]+"&"+nums[left]+"&"+nums[right])){
                            sets.add(nums[i]+"&"+nums[j]+"&"+nums[left]+"&"+nums[right]);
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]); list.add(nums[j]); list.add(nums[left]); list.add(nums[right]);
                            res.add(list);
                        }
                        left++;right--;
                    }
                }
            }
        }
        return res;
    }
}