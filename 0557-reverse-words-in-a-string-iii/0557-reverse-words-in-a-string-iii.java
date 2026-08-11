class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");

        for(int i = 0; i < str.length; i++){
            // new SB is for mutable..
            // Make it  reverse & string as well..
            str[i] = new StringBuilder(str[i]).reverse().toString();
        }
        // After reversing those are in array form. so, convert into normal String..
        return String.join(" ", str);  
    }
}