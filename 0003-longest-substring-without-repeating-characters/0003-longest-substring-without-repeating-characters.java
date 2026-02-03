class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>st = new HashSet<>();
        int n = s.length();

        int i = 0, maxi = 0;

        for(int j = 0; j < n; j++){

            // "contains" word checks duplicate elements
            while(st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }
            
            st.add(s.charAt(j));
            maxi = Math.max(maxi, j-i+1);
        }
        return maxi;
    }
}