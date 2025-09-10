class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        int n = nums.size();
        long long result = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int largest = nums[i];
            int smallest = nums[i];
            for(int j = i+1; j < n; j++){
                largest = max(largest,nums[j]);
                smallest = min(smallest, nums[j]);
                result = result + (largest - smallest);
            }
        }
        return result;
    }
};