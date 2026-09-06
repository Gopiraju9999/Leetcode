class Solution {
    public int scoreOfString(String s) {
        int n = s.length();
        int score = 0;

        for(int i = 0; i < n-1; i++){
            int ch1 = s.charAt(i);
            int index1 = ch1 - 'a';
            int ch2 = s.charAt(i+1);
            int index2 = ch2 - 'a';

            score += Math.abs(index1 - index2);
        }
        return score;
    }
}