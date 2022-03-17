class Solution {
    
    public static boolean isOperator(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
            return true;
        }
        return false;
    }
    
    public static void findValue(Stack<Integer>value,String s){
        int v2=value.pop();
        int v1=value.pop();
        if(s.equals("+")){
            value.push(v1+v2);
        }else if(s.equals("-")){
            value.push(v1-v2);
        }else if(s.equals("*")){
            value.push(v1*v2);
        }else{
            value.push(v1/v2);
        }
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> value = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            if(isOperator(s)){
                findValue(value,s);
            }else{
                value.push(Integer.parseInt(s));
            }
           
        }
         return value.peek();
    }
}