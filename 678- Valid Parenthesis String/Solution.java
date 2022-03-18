class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer>brc = new Stack<>();
        Stack<Integer>str = new Stack<>();
        for(int i = 0 ; i<s.length() ; i++) {
            
            char ch = s.charAt(i);
            
            if(ch=='(') {
                brc.push(i);
            }
            else if(ch=='*') {
                str.push(i);
            }
            else {
                
                if(brc.size()!=0) {
                    brc.pop();
                }
                else {
                    if(str.size()!=0)
                    {
                        str.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        while(brc.size()!=0) {
            if(str.size()!=0) {
                if(str.peek() < brc.peek()) {
                    return false;
                }
                else {
                    brc.pop();
                    str.pop();
                }
            }
            else {
                return false;
            }   
        }
        return true;
        
    }
}