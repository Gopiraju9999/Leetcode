class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character>st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        // 
        while(k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";

        StringBuilder result = new StringBuilder("");
        while(!st.isEmpty()){
            result.append(st.pop());
        }
        // Stack gives the reverse order..
        result.reverse();

        // removing leading zeroes from starting..
        int i = 0;
        while(i < result.length() && result.charAt(i) == '0'){
            i++;
        }
        result = new StringBuilder(result.substring(i));
        if(result.length() == 0) return "0";

        return result.toString();
    }
}