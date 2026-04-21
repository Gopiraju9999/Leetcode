class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int n = nums.size();
        int mini = 0, maxi = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] > nums[maxi]) maxi = i;
            if(nums[i] < nums[mini]) mini = i;
        }

        int l = min(mini, maxi);
        int r = max(mini, maxi);

        int case1 = (r + 1);
        int case2 = (n - l);
        int case3 = (l + 1) + (n - r);

        return min(case1, min(case2, case3));
    }
};