import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
           return a[0]-b[0]; 
        });
        Stack<int []>st = new Stack<>();
        st.push(intervals[0]);
        for(int i=0;i<intervals.length;i++){
            int []t = st.pop(); // yhn mila (1,3)
            int s1 = t[0];
            int e1=t[1];
            
            int s2 = intervals[i][0];
             int e2 = intervals[i][1];
            
            int Emax = Math.max(e1,e2);
            
            // mergeCondition
            if(e1>=s2){
                int[]merge = {s1,Emax};
                st.push(merge);
                // st.push(new int[]{s1,Emax});
            }else{
                st.push(t);
                st.push(intervals[i]);
            }
        }
        int [][] ans = new int[st.size()][2];
        for(int i=ans.length-1;i>=0;i--){
            int []temp = st.pop();
            ans[i][0]= temp[0];
            ans[i][1]= temp[1];
        }
        return ans;
    }
}