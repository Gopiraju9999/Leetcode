class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder ans = new StringBuilder();

        String[] str = s.split(" "); // Splits the string having space..
        for(int i = 0; i < k; i++){
            ans.append(str[i]).append(" "); 
        }
        return ans.toString().trim();  // way to ignore spaces at front & back
    }
}