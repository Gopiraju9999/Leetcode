class Solution {
    private boolean contains(int[] s_count, int[] t_count){
        // map_T is standard. Store the map_T characters frequency count into array..
        // Now check one by one character, while moving the map_S array..
        // It checks, if every character(index) in "map_T" array was greater than "map_S"
        // Return false. Because, the respective character freq is more than map_T..
        for(int i = 0; i < 256; i++){
            if(s_count[i] < t_count[i]){  
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        // Need 2 arrays to store the characters count at 0(1) space..
        int[] s_count = new int[256]; // lower[26], upper[26], both[52], ASCII[256]
        int[] t_count = new int[256];

        // String "t" characters are standard. So, store t characters..
        for(char ch : t.toCharArray()){
            t_count[ch]++;
        }

        // Remaining work will be, storing the string s characters one by one..
        // Keep tracking any of the character in "s" < "t". Then, shrink the window..
        int i = 0, min_length = Integer.MAX_VALUE, minstart = 0;

        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            s_count[ch]++;

            // It aloows if the character size is equal and checks for min length
            while(contains(s_count, t_count)){
                if(j-i+1 < min_length){
                    min_length = j-i+1;
                    minstart = i;
                }
                // It doesn't exist the characters, simpily shrink the window
                s_count[s.charAt(i)]--;
                i++;
            }
        }
        return min_length == Integer.MAX_VALUE ? 
        "" : s.substring(minstart, minstart+min_length);
    }
}