//大数集TLE
public class NumArray {
    int[] nums;
    HashMap<Integer,Integer> maps;
    
    int[] processed;
    boolean isUgly = false;
    public NumArray(int[] nums) {
        if(nums.length == 0){
            isUgly = true;
            return;
        }
        this.nums = nums;
        maps = new HashMap<>();
        processed = new int[nums.length];
      
        processed[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            processed[i] = processed[i-1]+nums[i];
        }
    }

    void update(int i, int val) {
        int gap = nums[i] - val;
        maps.put(i,gap);
    }

    public int sumRange(int i, int j) {
        Set set = maps.entrySet();
        Iterator iterator = set.iterator();
        int sum = 0;
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            int key = (int)entry.getKey();
            int value = (int)entry.getValue();
            if(key >= i && key <=j){
                sum+=value;
            }
        }
        return processed[j] - processed[i]+sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);



//通过使用TreeMap数据结构来实现map的有序化，然后利用submap选出在某段的大小，但仍然超时

import java.util.SortedMap;

public class NumArray {
    int[] nums;
    SortedMap<Integer,Integer> maps;
    
    int[] processed;
    boolean isUgly = false;
    public NumArray(int[] nums) {
        if(nums.length == 0){
            isUgly = true;
            return;
        }
        this.nums = nums;
        maps = new TreeMap<>();
        processed = new int[nums.length];
      
        processed[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            processed[i] = processed[i-1]+nums[i];
        }
    }

    void update(int i, int val) {
        int gap = nums[i] - val;
        maps.put(i,gap);
    }

    public int sumRange(int i, int j) {
        SortedMap<Integer,Integer> submap = maps.subMap(i,j+1);
        int sum = 0;
        
        Set set = submap.entrySet();
        Iterator iterator = set.iterator();
        
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            int value = (int)entry.getValue();
            sum += value;
        }
        return processed[j] - processed[i]+sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);

public class NumArray {
    int[] processed;
    int[] nums;
    int length;
    
    public NumArray(int[] nums) {
        length = nums.length;
        processed = new int[length+1];
        this.nums = nums;
        
        //init processed
        for(int i = 1;i<=length;i++){
            int sum = 0;
            int count = 1;
            int counter = lowBit(i);
            
            while(count <= counter){
                sum += nums[i-count];
                count++;
            }
            processed[i] = sum;
        }
    }

    void update(int i, int val) {
        //更新树状数组
        int gap = val - nums[i];
        nums[i] = val;
        
        int index = i+1;
        while(index <= length){
            processed[index] += gap;
            index += lowBit(index);
        }
    }

    public int sumRange(int i, int j) {
        return sum(j+1) - sum(i);
    }
    
    private int sum(int index){
        int sum = 0;
        while(index > 0){
            sum += processed[index];
            index -= lowBit(index);
        }
        return sum;
    }
    private int lowBit(int index){
        return index & (-index);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);