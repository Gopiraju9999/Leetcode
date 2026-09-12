class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return AtMost(nums, k) - AtMost(nums, k-1);
    }

    int AtMost(vector<int>&nums, int k){
        int n = nums.size();
        unordered_map<int,int>mpp;
        int i = 0, subarray_cnt = 0;

        for(int j = 0; j < n; j++){
            mpp[nums[j]]++;

            while(mpp.size() > k){
                mpp[nums[i]]--;

                if(mpp[nums[i]] == 0){
                    mpp.erase(nums[i]);
                }
                i++;
            }
            subarray_cnt += j-i+1;
        }
        return subarray_cnt;
    }
};