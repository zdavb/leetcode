public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        int ptr1 = 0,ptr2 = 0;
        int tmpPtr = 0;
        
        while(ptr1 < m && ptr2 < n){
            if(nums1[ptr1] < nums2[ptr2])
                tmp[tmpPtr++] = nums1[ptr1++];
            else
                tmp[tmpPtr++] = nums2[ptr2++];
        }
        while(ptr1 < m)
            tmp[tmpPtr++] = nums1[ptr1++];
        while(ptr2 < n)
            tmp[tmpPtr++] = nums2[ptr2++];
            
        System.arraycopy(tmp,0,nums1,0,m+n);
    }
}