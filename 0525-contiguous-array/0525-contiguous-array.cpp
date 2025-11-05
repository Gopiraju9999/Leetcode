class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size();

        for(int i = 0; i < n; i++){ // test: 3=> -1,1,1,1,1,1,-1,-1,-1
            if(nums[i] == 0) nums[i] = -1;
        }

        int sum = 0, max_len = 0;
        unordered_map<int,int>mpp{{0,-1}};

        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(mpp.count(sum)){
                int prev = i - mpp[sum];
                max_len = max(max_len, prev);
            } else{
                mpp[sum] = i;
            }
        }
        return max_len;
    }
};