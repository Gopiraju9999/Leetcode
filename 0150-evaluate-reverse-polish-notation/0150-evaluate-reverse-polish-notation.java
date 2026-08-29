class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st = new Stack<>();

        for(String token : tokens){
            // Checking my current element is pointing to operator or not??
            // if it is simply pop 2 elements and perform the respective operation
            // Push back the performed result into stack

                if(token.equals("+")){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a+b);
                }else if(token.equals("-")){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a-b);
                }else if(token.equals("*")){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a*b);
                }else if(token.equals("/")){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a/b);
                }
                // Here we get the only numbers. so, simply push into stack..
                else{
                    st.push(Integer.parseInt(token));
                }
        }
        // At the end, the top of stack will be answer. so, simply return it..
        return st.pop();
    }
}