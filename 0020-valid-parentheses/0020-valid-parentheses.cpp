class Solution {
public:
    bool isValid(string s) {
        stack<char>st;
        unordered_map<char,char>mpp = {
            {')', '('},
            {']', '['},
            {'}', '{'}
        };
        for(char c : s){
            if(mpp.count(c)){
                if(st.empty() || st.top() != mpp[c]){
                    return false;
                }
                st.pop();
            }else{
                st.push(c);
            }
        }
        return true;
    }
};