class Solution {
public:
    string removeKdigits(string num, int k) {
        stack<char>st;
        int n = num.size();

        for(int i = 0; i < n; i++){
            while(!st.empty() && st.top() > num[i] && k > 0){
                st.pop();
                k--;
            }
            st.push(num[i]);
        }
        while(k > 0){
            st.pop();
            k--;
        }
        if(st.empty()) return "0";

        string res = "";
        // Construct the result from the stack
        while(!st.empty()){
            res += st.top();
            st.pop();
        }
        // Removing the leading Zeroes
        while(!res.empty() && res.back()=='0'){
            res.pop_back();
        }
        // The result is in reverse order. so, reverse it!!
        reverse(res.begin(), res.end());

        if(res.empty()) return "0";

        return res;
    }
};