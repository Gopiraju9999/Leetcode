class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[256];
        int i = 0, maxi = 0;

        for(int j = 0; j < n; j++){
            char ch = s.charAt(j);
            freq[ch]++;

            while(freq[ch] > 1){
                freq[s.charAt(i)]--;
                i++;
            }
            maxi = Math.max(maxi, j-i+1);
        }
        return maxi;
    }
}