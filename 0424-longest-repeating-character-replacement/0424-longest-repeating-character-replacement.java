class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int i = 0, max_freq = 0, max_win = 0;

        for(int j = 0; j < n; j++){
            char ch = s.charAt(j);

            freq[ch - 'A']++;
            max_freq = Math.max(max_freq, freq[ch - 'A']);
            //int win_len = j-i+1;

            // Shrink the window...
            if((j-i+1) - max_freq > k){
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            max_win = Math.max(max_win, j-i+1);
        }
        return max_win;
    }
}