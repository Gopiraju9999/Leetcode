class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int[] freq = new int[26];
        int i = 0, max_len = 0, max_win = 0;

        for(int j = 0; j < n; j++){
            char ch = answerKey.charAt(j);
            freq[ch - 'A']++;
            max_len = Math.max(max_len, freq[ch - 'A']);

            // Condition is out of bound, so shrink the window and decrease the freq as well..
            while((j-i+1) - max_len > k){
                freq[answerKey.charAt(i) - 'A']--;
                i++;
            }
            
            max_win = Math.max(max_win, j-i+1);
        }
        return max_win;
    }
}