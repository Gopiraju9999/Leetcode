class Solution {
    public String largestEven(String s) {
        int n = s.length();
        int last_index = -1;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '2')
                last_index = i;
        }

        if(last_index == -1)
            return "";

        return s.substring(0, last_index + 1);
    }
}