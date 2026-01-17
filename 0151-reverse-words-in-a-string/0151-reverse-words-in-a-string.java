class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();

        String ans = "";

        for(int i = 0; i < n; i++){
            String word = "";

            while(i < n && s.charAt(i) != ' '){
                word += s.charAt(i);
                i++;
            }

            StringBuilder w = new StringBuilder(word);
            w.reverse();

            if(word.length() > 0)
                ans += " "+w.toString();

        }
        return ans.substring(1);
    }
}