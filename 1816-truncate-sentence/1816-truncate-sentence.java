class Solution {
    public String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        String result = "";

        for(int i = 0; i < k; i++){
            result += " " + str[i];
        }
        return result.trim();
    }
}