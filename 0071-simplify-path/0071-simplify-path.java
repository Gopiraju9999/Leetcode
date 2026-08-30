class Solution {
    public String simplifyPath(String path) {
        Stack<String>st = new Stack<>();

        String[] parts = path.split("/");

        for(String part : parts){
            // Ignore the current directory & extra spaces..
            if(part.equals("") || part.equals(".")){
                continue;
            }
            // ".." means previous directory, simpily remove the top element from stack..
            else if(part.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            // Remaining part will be like adding into stack..
            else{
                st.push(part);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            // It stores like always keep popping the top element and adding 0th idx of string
            // stack => stack, home, bar
            // "stack" popped and add front of string "result -> "/stack""
            // pop "home" and string like "result -> "/home/stack"" etc...
            result.insert(0, "/" + st.pop());
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}