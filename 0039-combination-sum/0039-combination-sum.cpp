class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
      vector<int>current;
      vector<vector<int>>result;

      Backtrack(candidates, target, 0, current, result);
      return result;   
    }
    void Backtrack(vector<int>& candidates, int target, int start,vector<int>& current,
    vector<vector<int>>& result){
        if(target == 0){
            result.push_back(current);
            return;
        }
        for(int i = start; i < candidates.size(); i++){
            if(candidates[i] > target){
                continue;
            }
            current.push_back(candidates[i]);
            Backtrack(candidates, target-candidates[i], i, current, result);
            current.pop_back();
        }
    }
};