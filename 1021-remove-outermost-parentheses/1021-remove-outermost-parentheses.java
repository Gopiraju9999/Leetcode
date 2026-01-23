class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for(char c : s.toCharArray()){
            if(c == '('){                       // "(" counts no. of times occured
                if(depth > 0) result.append(c);  // ""> 0" means it is not outermost bracket..
                depth++;
            }else{
                depth--;                         // ")" decrements the depth count
                if(depth > 0) result.append(c);  // ""> 0" means it is not outermost onee..
            }
        }
        return result.toString();               // At the end, result can be convert into string
    }
}