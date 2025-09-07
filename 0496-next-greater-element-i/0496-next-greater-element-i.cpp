class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        stack<int>st;
        int n1 = nums1.size();
        int n2 = nums2.size();
        unordered_map<int,int>mpp;
        for(int i = n2-1; i >= 0; --i){
            while(!st.empty() && nums2[i] >= st.top()){
                st.pop(); // remove the last element from the stack
            }
            mpp[nums2[i]] = st.empty() ? -1 : st.top();
            st.push(nums2[i]);
        }
        vector<int>res;
        for(int num : nums1){
            res.push_back(mpp[num]);
        }
        return res;
    }
};