class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>st = new Stack<>();

        for(String op : operations){
            // "POP" top element and double it, and push it into stack..
            if(op.equals("D")){
                st.push(st.peek()*2);
            }else if(op.equals("C")){ // Simpily "POP" it from the stack
                st.pop();
            }else if(op.equals("+")){ // "POP" top 2 elements & push back 2 elements & result 
                int first = st.pop();
                int second = st.peek();
                st.push(first);
                st.push(first + second);
            }else{                  // It means pointing to number push it
                st.push(Integer.parseInt(op)); // This is for converting "string into integer"
            }
        }
        int score = 0;
        
        while(!st.isEmpty()){       // Always keep storing the top element and pop it as well
            score += st.pop();
        }

        return score;
    }
}