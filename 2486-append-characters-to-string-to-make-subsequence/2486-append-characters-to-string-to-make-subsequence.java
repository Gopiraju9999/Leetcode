class Solution {
    public int appendCharacters(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int i = 0, j = 0;

        while(i < n1 && j < n2){
            char c = s.charAt(i);
            char h = t.charAt(j);
            // If both characters are equal, increment both pointers
            if(c == h){
                i++;
                j++;
            }
            // Else, increment i pointer only..
            else{
                i++;
            }
        }
        // Length to appending last at string "s"
        return n2 - j;
    }
}