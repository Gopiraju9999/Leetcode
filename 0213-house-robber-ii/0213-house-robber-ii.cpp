class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        return max(robber(nums, 0, n-2), robber(nums, 1, n-1));
    }
    int robber(vector<int>& nums, int start, int end){
        int prev_1 = 0, prev_2 = 0;

        for(int i = start; i <= end; i++){
            int curr = max(nums[i] + prev_2, prev_1);
            prev_2 = prev_1;
            prev_1 = curr;
        }
        return prev_1;
    }
};