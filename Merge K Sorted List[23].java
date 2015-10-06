//TLE版本
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        
        boolean hasFound = true;
        while(hasFound){
            hasFound = false;
            ListNode node = null;
            int index = 0;
            for(int i = 0;i<lists.length;i++){
                if(lists[i]!=null){
                    if(node == null){
                        node = lists[i];
                        index = i;
                    }else if(lists[i].val<node.val){
                        node = lists[i];
                        index = i;
                    }
                }
            }
            if(node!=null){
                hasFound = true;
                lists[index] = lists[index].next;
                prev.next = node;
                prev = node;
            }
        }
        return head.next;
    }
}

//使用优先队列
//idea是如果每添加一个元素都要去遍历一遍listnode数组，来找最小元素是没有必要的
//因为在第一遍遍历时，基本大小情况已经知道了。
//通过维护一个优先队列，每次取队首的元素，然后将队首的next元素添加到队列中
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue(new Comparator(){
            public int compare(Object arg0, Object arg1) {  
                int val1 = ((ListNode)arg0).val;  
                int val2 = ((ListNode)arg1).val;  
                return val1-val2;
            }  
        }); 
        //init queue
        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null)
                queue.offer(lists[i]);
        }
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while(queue.size()!=0){
            ListNode top = queue.poll();
            prev.next = top;
            prev = top;
            if(top.next!=null)
                queue.offer(top.next);
        }
        return head.next;
    }
}