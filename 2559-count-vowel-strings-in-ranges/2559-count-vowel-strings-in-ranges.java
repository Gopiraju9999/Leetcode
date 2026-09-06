class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] answer = new int[queries.length];
        int[] prefix = new int[words.length];

        // Do the prefix sum for simplification of counting..
        // If the vowel is present at starting & ending. Then, increment the count
        for(int i = 0; i < n; i++){
            String word = words[i];
            int count = 0;

            // 1st & last letters in word
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if(IsVowel(first) && IsVowel(last)){
                count++;
            }
            prefix[i] = count;     // Initailly, took the exact count

            // After the 1st index start doing the prefix sum at a time..
            if(i > 0){
                prefix[i] += prefix[i-1];
            }
        }

        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            
            // Where the left is "0" directly add the count of vowels in answer array
            // Else, do the subtarction from the prefix array right & left - 1
            if(left == 0){
                answer[i] = prefix[right];
            }else{
                answer[i] = prefix[right] - prefix[left - 1];
            }
        }
        return answer;
    }
    private boolean IsVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}