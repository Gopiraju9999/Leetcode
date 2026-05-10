class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int open_bra = 0;

        // Intially add into elements into string..
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open_bra++;
                result.append(ch);
            }else if(ch == ')'){
                if(open_bra > 0){
                    open_bra--;
                    result.append(ch);
                }
            }else{
                result.append(ch);
            }
        }

        // After 
        StringBuilder ans = new StringBuilder();
        for(int i = result.length()-1; i >= 0; i--){
            char ch = result.charAt(i);

            if(ch == '(' && open_bra > 0){
                open_bra--;
                continue;
            }
            ans.append(ch);
        }
        return ans.reverse().toString();
    }
}