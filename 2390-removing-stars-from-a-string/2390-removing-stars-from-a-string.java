class Solution {
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character>st = new Stack<>();
        if(n == 0) return "";

        for(int i = 0; i  < n; i++){
            if(s.charAt(i) == '*'){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder("");
        while(!st.isEmpty()){
            result.append(st.peek());
            st.pop();
        }
        return result.reverse().toString();
    }
}