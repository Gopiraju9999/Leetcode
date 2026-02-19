class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character>st = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(!st.isEmpty() && ch == st.peek()){
                st.pop();
            }else{
             st.push(ch);
            }
        }

        StringBuilder result = new StringBuilder("");
        for(char ch : st){
            result.append(ch);
        }
        return result.toString();
    }
}