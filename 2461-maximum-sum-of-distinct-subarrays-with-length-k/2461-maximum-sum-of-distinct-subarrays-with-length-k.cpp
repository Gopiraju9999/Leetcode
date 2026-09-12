class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        unordered_set<int>st;
        long long sum = 0, maxi_sum = 0;

        int i = 0;
        for(int j = 0; j < n; j++){

            // Check the element present in the set or not??
            while(st.find(nums[j]) != st.end()){
                st.erase(nums[i]);
                sum -= nums[i];
                i++;
            }
            // Or else, add into set
            st.insert(nums[j]);
            sum += nums[j];

            // if my window size is "k-sized". Then, calculate sum & keep maximum shrink window
            if(j-i+1 == k){
                maxi_sum = max(maxi_sum, sum);
                st.erase(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return maxi_sum;
    }
};