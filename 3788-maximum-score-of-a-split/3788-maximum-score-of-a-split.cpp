class Solution {
public:
    long long maximumScore(vector<int>& nums) {
        int n = nums.size();

        vector<long long>suffix_min(n);
        suffix_min[n-1] = nums[n-1];

        for(int i = n-2; i >= 0; i--){
            suffix_min[i] = min((long long)nums[i], suffix_min[i+1]);
        }

        long long prefix = 0;
        long long maxi = LLONG_MIN;

        for(int i = 0; i < n-1; i++){
            prefix += nums[i];
            maxi = max(maxi, prefix - suffix_min[i+1]);
        }
        return maxi;
    }
};