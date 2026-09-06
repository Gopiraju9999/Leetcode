class Solution {
public:
    int scoreOfString(string s) {
        int n = s.length();
        int score = 0;

        for(int i = 0; i < n-1; i++){
            int ch1 = s[i];
            int idx1 = ch1 - 'a';
            int ch2 = s[i+1];
            int idx2 = ch2 - 'a';

            score += abs(idx1 - idx2);
        }
        return score;
    }
};