class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        stack<int>st;
        int n1 = nums1.size();
        int n2 = nums2.size();
        unordered_map<int,int>mpp;
        for(int num : nums2){
            while(!st.empty() && num > st.top()){
                mpp[st.top()] = num;
                st.pop(); // remove the last element from the stack
            }
            st.push(num);
        }
        while(!st.empty()){
            mpp[st.top()] = -1;
            st.pop();
        }
        vector<int>res;
        for(int num : nums1){
            res.push_back(mpp[num]);
        }
        return res;
    }
};