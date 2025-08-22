class Solution {
public:
    bool isfreqsame(int freq1[], int freq2[]){
        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
    bool checkInclusion(string s1, string s2) {
        if(s1.size() > s2.size()) return false;

        int freq[26] = {0}; // s1 => i (pointer)
        for(int i = 0; i<s1.size(); i++){
            freq[s1[i] - 'a']++;
        }
        int window_size = s1.size();
        for(int i = 0; i<s2.size(); i++){
            int window_idx = 0; // window starting point 
            int idx = i; // window ending point 
            int window_freq[26] = {0};
            while(window_idx < window_size && idx < s2.size()){ // till goes end of s2 length
                window_freq[s2[idx] - 'a']++; // increment the frequency
                window_idx++; idx++; // always move the move
            }
            if(isfreqsame(freq, window_freq)) return true;
        }
        return false;
    }
};