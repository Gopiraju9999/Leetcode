class Solution {
    public String longestPalindrome(String s) {
        int m = s.length();
        String result = "";

        for(int i = 0; i < m; i++){
            for(int j = i; j < m; j++){
                String sub = s.substring(i, j+1);
                if(Palindrome(sub) && sub.length() > result.length()){
                    result = sub;
                }
            }
        }
        return result;
    }
    private boolean Palindrome(String s){
        int n = s.length();
        int i = 0, j = n-1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}