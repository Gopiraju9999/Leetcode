class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length() == 0) return 0;

        int open_bracket = 0, close_bracket = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open_bracket++;
            }else{
                if(open_bracket > 0){
                open_bracket--;
                }else{
                    close_bracket++;
                }
            }
        }
        return open_bracket + close_bracket;
    }
}