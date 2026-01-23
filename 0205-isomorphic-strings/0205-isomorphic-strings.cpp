class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.length() > t.length() || s.length() < t.length()) return false;

        unordered_map<char, char>mpp1;
        unordered_map<char, char>mpp2;

        for(int i = 0; i < s.size(); i++){
            char c1 = s[i];
            char c2 = t[i];

            if(mpp1.count(c1)){
                if(mpp1[c1] != c2) return false;
            }else{
                mpp1[c1] = c2;
            }

            if(mpp2.count(c2)){
                if(mpp2[c2] != c1) return false;
            }else{
                mpp2[c2] = c1;
            }
        }
        return true;
    }
};