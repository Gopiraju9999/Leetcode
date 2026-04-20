class Solution {
    public long countVowels(String word) {
        int n = word.length();
        long count = 0;

        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(isVowel(ch)){
                count += (long)(i + 1) * (n - i);
            }
        }
        return count;
    }
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}