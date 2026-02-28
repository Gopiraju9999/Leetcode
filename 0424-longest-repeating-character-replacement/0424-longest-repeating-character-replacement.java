class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int max_freq = 0, max_window = 0;
        int i = 0;

        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);

            freq[ch - 'A']++;       // Add into the array & increment the count of character..
            max_freq = Math.max(max_freq, freq[ch - 'A']);
            int window_len = j-i+1;

            // Beyond the condition.. Shrink the window..
            if(window_len - max_freq > k){
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            window_len = j-i+1;
            max_window = Math.max(max_window, window_len);
        }
        return max_window;
    }
}