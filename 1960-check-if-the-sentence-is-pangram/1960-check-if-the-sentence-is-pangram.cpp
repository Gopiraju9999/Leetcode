class Solution {
public:
    bool checkIfPangram(string sentence) {
        int freq[26];
        for(int i = 0; i < sentence.length(); i++){
            int index = sentence[i] - 'a';
            freq[index]++;
        }
        for(int i = 0; i <= 25; i++){
            if(freq[i] == 0) return false;
        }
        return true;
    }
};