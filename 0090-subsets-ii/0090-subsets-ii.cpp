class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>>result;
        vector<int>path;
        sort(nums.begin(), nums.end());
        Backtrack(nums, 0, path, result);
        return result;
    }
    void Backtrack(vector<int>& nums, int start, vector<int>path,vector<vector<int>>& 
    result){
        result.push_back(path); // includes the empty set

        for(int i = start; i < (int)nums.size(); i++){
            if(i > start && nums[i] == nums[i-1]) continue;
           path.push_back(nums[i]); // Choose
           Backtrack(nums, i+1, path, result); // Explore
           path.pop_back();  // Unchoose
        }
    }
};