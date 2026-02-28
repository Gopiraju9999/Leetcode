class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] countP = new int[26]; // Standard no need to change the size..
        int[] countS = new int[26];
        List<Integer>result = new java.util.ArrayList<>();

        for(char ch : p.toCharArray()){ // Adding elements frequency
            countP[ch - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            countS[s.charAt(i) - 'a']++;  // Always adding frequency with size of "p"..

            if(i >= p.length()){
                countS[s.charAt(i - p.length()) - 'a']--; // Remove 1st element in window
            }

            if(Arrays.equals(countP, countS)){
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}