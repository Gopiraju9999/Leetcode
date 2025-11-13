class Solution {
public:
    string frequencySort(string s) {
       unordered_map<char,int>mpp;
       for(int num : s){
        mpp[num]++;
       } 

       priority_queue<pair<int,char>>minh; // storing like {frequency , chracter}
       for(auto i:mpp){
        char c = i.first; //1st as char(letter)
        int freq = i.second; // 2nd as letter frequency
        minh.push({freq,c}); // storing like (1,t) & (1,r) & (2,e)
       }

       string res ="";  // empty string for return answer
       while(!minh.empty()){
        auto i = minh.top(); //store into result
        minh.pop();  //remove from the heap

        res.append(i.first, i.second);
       }
       return res;
    }
};