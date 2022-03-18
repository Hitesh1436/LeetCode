import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) { 
        int n = nums1.length;
        int m = nums2.length;
        
        int [] nextGreater = nextGreaterElementToTheRight(nums2);
        int [] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums1[i] == nums2[j]){
                    ans[i] = nextGreater[j];
                }
            }
        }
        
        return ans;
    }
    
    public int [] nextGreaterElementToTheRight(int [] nums2){
        int n = nums2.length;
        int [] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(st.size() != 0 && nums2[st.peek()] < nums2[i]){
                int idx = st.pop();
                ans[idx] = nums2[i];
            }
            st.push(i);
        }
        return ans;
    }
    
}