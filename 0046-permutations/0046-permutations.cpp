class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
       vector<vector<int>>result;
       Backtrack(nums, 0, result);
       return result; 
    }
    void Backtrack(vector<int>& nums, int i, vector<vector<int>>& result){
        if(i == nums.size()){
            result.push_back(nums);
            return;
        }
        for(int j =i; j < nums.size(); j++){
            swap(nums[i], nums[j]);
            Backtrack(nums, i+1, result);
            swap(nums[i], nums[j]);
        }
    }
};