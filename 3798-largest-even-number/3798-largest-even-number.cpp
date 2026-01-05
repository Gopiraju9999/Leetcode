class Solution {
public:
    string largestEven(string s) {
        int n = s.size();
        int last_index = -1;

        for(int i = 0; i < n; i++){
            if(s[i] == '2')
                last_index = i;
            
        }

        if(last_index == -1)
            return "";

        return s.substr(0, last_index + 1);
    }
};