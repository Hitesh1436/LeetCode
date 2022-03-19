class Solution {
    public int findMaxLen(String s) {
        int max = 0;
        Stack<Integer> st = new Stack();
        st.push(-1);
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.size()==0){
                    st.push(i);
                }
                else{
                    max = Math.max(max , i - st.peek());
                }
            }
        }
        return max;
    }
}