class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        //1. Skip leading whitespaces..
        while(i<n && s.charAt(i) == ' '){
            i++;
        }
        
        //2. sign check..
        int sign = 1;
        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        // Read numbers..
        long num = 0;
        while(i < n && (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
            num = num * 10 + (s.charAt(i) - '0');

            // Handle overflow..
            if(sign == 1 && num > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            if(sign == -1 && -num < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign * num);
    }
}