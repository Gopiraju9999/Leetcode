class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
       int n = nums.size();
       stack<int> s;
       vector<int> res(n, -1);
        
     for(int i = 2 * n - 1; i >= 0; --i) {
      int num = nums[i % n];
     while(!s.empty() && s.top() <= num) s.pop(); // remove the small one(last onr in stack)
     if(!s.empty()) res[i % n] = s.top(); // add into vector the top element
     s.push(num); 
     }
     return res;
    }
};