class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();

        int n = s.length();
        int length = 0;

        for(int i = n-1; i >= 0; i--){
            char ch = s.charAt(i);
            
            if(ch > 0 && ch == ' '){
                break;
            }
            length++;
        }
        return length;
    }
}