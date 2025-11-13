class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string,int>mpp;
        for(string word : words){
            mpp[word]++;
        }

        priority_queue<pair<int, string>>minh;
        for(auto i : mpp){
            minh.push({-i.second, i.first}); // Here 2nd is frequency, 1st is string
            if(minh.size() > k){
                minh.pop();
            }
        }

        vector<string>ans;
        for(int i = 0; i<k; i++){
            ans.push_back(minh.top().second); // store only frequency
            minh.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};