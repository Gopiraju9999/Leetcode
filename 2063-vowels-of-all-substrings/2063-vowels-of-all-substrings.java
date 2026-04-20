class Solution {
    public long countVowels(String word) {
        int len = word.length();
        long count = 0;

        for(int pos = 0; pos < len; pos++){
            char ch = word.charAt(pos);
            if(isVowel(ch)){
                count += (long)(pos + 1) * (len - pos);
            }
        }
        return count;
    }
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}