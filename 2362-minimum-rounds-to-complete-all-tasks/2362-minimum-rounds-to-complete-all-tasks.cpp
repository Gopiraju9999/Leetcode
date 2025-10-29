class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        int n = tasks.size();
        int count = 0;

        unordered_map<int,int>mpp;
        for(int task : tasks){
            mpp[task]++;
        }

        for(auto& it : mpp){
            if(it.second == 1){
                return -1;
            }
            else if(it.second == 2 || it.second == 3){
                count++;
            }
            else{
                count += (it.second+2)/3; 
            }
        }
        return count;
    }
};