class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        if(n < 3) return 0;

        int i = 0, Sub_str_count = 0;
        int[] charcount = new int[3];

        for(int j = 0; j < n; j++){

            charcount[s.charAt(j) - 'a']++;

            // This is the valid condition for counting the substrings..
            while(charcount[0] > 0 && charcount[1] > 0 && charcount[2] > 0){
                Sub_str_count += n - j;     // Formulae to count the substrings..
                // Shrinking the window..
                charcount[s.charAt(i) - 'a']--; 
                i++;
            }
        }
        return Sub_str_count;
    }
}