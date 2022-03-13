import java.util.*;
class Solution {
    
    public static int[] nextSmallerOnLeft(int []arr){
        int n = arr.length;
        int []ans = new int[n];
        // Arrays.fill(ans,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()!=0 && arr[st.peek()]>arr[i]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        while(st.size()!=0){
            int idx = st.pop();
            ans[idx] = -1;
        }
        return ans;
    }
    
    public static int[] nextSmallerOnRight(int []arr){
     int n = arr.length;
        int []ans = new int[n];
        // Arrays.fill(ans,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()!=0 && arr[st.peek()]>arr[i]){
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }
        while(st.size()!=0){
            int idx = st.pop();
            ans[idx] = n;
        }
        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
        int h = heights.length;
        int []nsoL = nextSmallerOnLeft(heights);
        int []nsoR = nextSmallerOnRight(heights);
        int max =0;
        for(int i=0;i<h;i++){
            int w = nsoR[i]-nsoL[i] -1;
            int area = heights[i]*w;
            max = Math.max(max,area);
        }
        return max;
    }
}