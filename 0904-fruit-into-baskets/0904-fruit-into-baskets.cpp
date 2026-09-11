class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        unordered_map<int, int>mpp;
        int n = fruits.size();
        int maxi_fruits = 0, i = 0;

        for(int j = 0; j < n; j++){
            mpp[fruits[j]]++;

            while(mpp.size() > 2){
                mpp[fruits[i]]--;

                if(mpp[fruits[i]] == 0){
                    mpp.erase(fruits[i]);
                }
                i++;
            }
            maxi_fruits = max(maxi_fruits, j-i+1);
        }
        return maxi_fruits;
    }
};