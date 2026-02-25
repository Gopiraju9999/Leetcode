class Solution {
    private boolean contains(int[] map_S, int[] map_T){
        for(int i = 0; i < 256; i++){
            if(map_S[i] < map_T[i]){  // Way to check character by character in both maps..
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] map_S = new int[256]; // lowercase => "26",   uppercase => "52"
        int[] map_T = new int[256]; // ASCII values => "256"

        for(char ch : t.toCharArray()){ // Storing characters into map
            map_T[ch]++;
        }

        int i = 0, min_len = Integer.MAX_VALUE, minstart = 0;

        for(int j = 0; j < s.length(); j++){
            map_S[s.charAt(j)]++;

            while(contains(map_S, map_T)){
                if(j-i+1 < min_len){
                    min_len = j-i+1;
                    minstart = i;
                }
                map_S[s.charAt(i++)]--;
            }
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(minstart, minstart+min_len);
    }
}