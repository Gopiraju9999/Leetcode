class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.size() > s2.size()) return false;

       vector<int> s1count(26,0), s2count(26,0);

       for(int i = 0; i < s1.size(); i++){
        s1count[s1[i] - 'a']++;
        s2count[s2[i] - 'a']++;
       }
        for(int i = 0; i< s2.size() - s1.size(); i++){
            if(s1count == s2count) return true;
            // update the window (move forward)
            s2count[s2[i] - 'a']--;
            s2count[s2[i + s1.size()] - 'a']++;
        }
        return s1count == s2count;
    }
};