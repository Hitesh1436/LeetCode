class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<ops.length;i++){
            String s = ops[i];
            if(s.equals("C")){
                st.pop();              // Invalidate ke liye 
            }else if(s.equals("D")){
                int x = st.peek();
                st.push(x*2);        // double kia h 
            }else if(s.equals("+")){
                int v2 = st.pop();
                int v1 = st.peek();
                int sum = v1 + v2;
                st.push(v2);
                st.push(sum);
            }else{
                int num = Integer.parseInt(s);
                st.push(num);
            }
        }
        int ans=0;
        while(st.size()!=0){
            ans += st.pop();
        }
        return ans;
    }
}