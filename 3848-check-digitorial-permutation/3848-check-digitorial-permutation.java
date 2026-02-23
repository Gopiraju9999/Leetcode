class Solution {
    public boolean isDigitorialPermutation(int n) {
        int m = n;
        String s = String.valueOf(m);   // Way to convert the "integer" => "String"
        int sum = 0;

        // Computed the factorials of numbers from 0 to 9..
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        for(int i = 0; i < s.length(); i++){
            int digit = s.charAt(i) - '0';      // Current number in string form..
            sum += fact[digit];
        }
        return isValidPermutation(s, String.valueOf(sum));
    }

    // The output is always a permutation of given input. So, that's why permutation func needed
    
    public boolean isValidPermutation(String a, String b){
        if(a.length() != b.length()) return false;
        if(b.charAt(0) == '0') return false;

        int[] count = new int[10];

        for(char c : a.toCharArray()) count[c - '0']++;
        for(char c : b.toCharArray()) count[c - '0']--;

        for(int x : count){
            if(x != 0) return false;
        }
        return true;
    }
}