class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int[] freq = new int[2];
        int i = 0, max_len = 0, max_win = 0;

        for(int j = 0; j < n; j++){
            char ch = answerKey.charAt(j);

            int idx = (ch == 'T') ? 0 : 1; // Point to the index only
            freq[idx]++;

            while(Math.min(freq[0], freq[1]) > k){
                char left_char = answerKey.charAt(i);

                int left_idx = (left_char == 'T') ? 0 : 1; // For only point to index
                freq[left_idx]--;
                i++;
            }
            max_win = Math.max(max_win, j-i+1);
        }
        return max_win;
    }
}