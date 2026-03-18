class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        int res = INT_MAX;
        long long sum = 0;
        int n = nums.size();
        deque<pair<long long, int>>q;  //{ prefix_sum, end_idx}

        // Prefix sum 
        for(int r = 0; r < n; r++){
            sum += nums[r];
            if(sum >= k){
                res = min(res, r+1);
            }
            // Find the minimum valid window ending at "r"
            while(!q.empty() && sum - q.front().first >= k){
                auto [prefix, endIdx] = q.front();
                q.pop_front();  // target is greater, remove the 1st one like shrinking it!
                res = min(res, r - endIdx); // (result of subarray, length of subarray)
            }
            // validate the Monotonic deque
            while(!q.empty() && q.back().first > sum){ // first element is greater in deque
                q.pop_back();                          // remove it
            }
            q.push_back({sum, r}); // add into the deque, as per the created one(sum, index"i")
        }
        return res == INT_MAX ? -1 : res;
    }
};