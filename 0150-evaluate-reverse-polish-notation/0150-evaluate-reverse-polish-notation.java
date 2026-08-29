class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st = new Stack<>();

        for(String token : tokens){
            // Checking my current element is pointing to operator or not??
            // if it is simply pop 2 elements and perform the respective operation
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b = st.pop();
                int a = st.pop();
                int result = 0;
                
                // The operations which will be exist..
                if(token.equals("+")){
                    result = a + b;
                }else if(token.equals("-")){
                    result = a - b;
                }else if(token.equals("*")){
                    result = a * b;
                }else{
                    result = a / b;
                }
                st.push(result);
            }
            // Here is the condition only for the numbers
            // push into it & convert into interger value
            else{
                st.push(Integer.parseInt(token));
            }
        }
        // At the end, we have the answer only at the top
        // Then return it..
        return st.pop();
    }
}