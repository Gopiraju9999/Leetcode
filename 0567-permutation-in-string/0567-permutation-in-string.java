class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1_count = new int[26];
        int[] s2_count = new int[26];

        for(char ch : s1.toCharArray()){
            s1_count[ch - 'a']++;
        }

        for(int i = 0; i < s2.length(); i++){
            s2_count[s2.charAt(i) - 'a']++;

            // Beyond the window length..
            if(i >= s1.length()){
                s2_count[s2.charAt(i -s1.length()) - 'a']--;
            }

            // Here we got permutation..
            if(Arrays.equals(s1_count, s2_count)){
                return true;
            }
        }
        return false;
    }
}