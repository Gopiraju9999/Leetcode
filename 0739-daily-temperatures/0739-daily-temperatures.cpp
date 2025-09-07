class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        stack<int>st;
        vector<int>ans(n,0);
        for(int i = 0; i < n; i++){
            while(!st.empty() && temperatures[i] > temperatures[st.top()]){
                int previdx = st.top(); st.pop(); // remove the top element
                ans[previdx] = i - previdx;
            }
            st.push(i); // new element push into the stack
        }
        return ans;
    }
};