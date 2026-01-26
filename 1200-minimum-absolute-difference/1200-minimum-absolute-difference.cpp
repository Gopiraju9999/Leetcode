class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        int n = arr.size();

        int mini_diff = INT_MAX, diff = 0;

        for(int i = 0; i < n-1; i++){
            diff = arr[i+1] - arr[i];
            mini_diff = min(mini_diff, diff);
        }

        vector<vector<int>>ans;

        for(int j = 0; j < n-1; j++){
            if(arr[j+1] - arr[j] == mini_diff)
                ans.push_back({arr[j], arr[j+1]});
        }
        return ans;
    }
};