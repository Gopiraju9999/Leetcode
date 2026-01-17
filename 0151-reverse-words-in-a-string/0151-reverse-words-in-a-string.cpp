class Solution {
public:
    string reverseWords(string s) {
       int n = s.size();
       string ans = "";
       reverse(s.begin(), s.end());    // Reverse entire given string

       for(int i = 0; i < n; i++){
        string word = "";
        while(i < n && s[i] != ' '){    // It checks 1 word at time
            word += s[i];
            i++;
        }

        reverse(word.begin(), word.end()); // word in reverse form, reverse it for correct form

        if(word.size() > 0)     // in case there is a empty space, no need to add space
            ans += " "+ word;

       }
       return ans.substr(1); // it converts into string from the 1st space
    }
};