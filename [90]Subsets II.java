public class Solution {
    HashSet<String> sets;
    List<List<Integer>> list;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        sets = new HashSet<>();
        list = new LinkedList<>();
        List<Integer> tmplist = new LinkedList<>();  
        
        Arrays.sort(nums);
        searchSubset(nums,0,tmplist);
        return list;
    }
    private void searchSubset(int[] nums,int index,List<Integer> tmplist){
        if(index == nums.length){
            StringBuilder builder = new StringBuilder();
            int size = tmplist.size();
            for(int i = 0;i<size;i++){
                builder.append(tmplist.get(i));
                builder.append(',');
            }
            String s = builder.toString();
            //查重
            if(!sets.contains(s)){
                list.add(new LinkedList<>(tmplist));  
                sets.add(s);
            }
            return;
        }
        //not add to list
        searchSubset(nums,index+1,tmplist);
        //add to list
        tmplist.add(nums[index]);
        searchSubset(nums,index+1,tmplist);
        tmplist.remove(tmplist.size()-1);
    }
}