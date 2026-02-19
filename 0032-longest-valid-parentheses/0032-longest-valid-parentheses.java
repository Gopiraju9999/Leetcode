class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer>st = new Stack<>();
        st.push(-1);
        int max_len = 0;

        if(n == 0) return 0;

        for(int i = 0; i < n; i++){
           if(s.charAt(i) == '('){
                st.push(i);
           }else{
                
                if(s.charAt(i) == ')' && st.size() > 1 && s.charAt(st.peek()) == '('){
                    st.pop();
                    max_len = Math.max(max_len, i - st.peek());
                }else{
                    st.push(i);
                }
           }
        }
        return max_len;
    }
}