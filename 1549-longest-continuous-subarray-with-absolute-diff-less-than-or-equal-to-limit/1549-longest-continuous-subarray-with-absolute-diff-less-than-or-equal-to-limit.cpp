class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        deque<int>dec; // store the elements in decreasing order
        deque<int>inc; // store the elements in increasing order
        int ans = 0, left = 0;
        for(int right = 0; right  < nums.size(); right++){
            int num = nums[right];
            while(!dec.empty() && num > dec.back()){ // new element is bigger than back element
                dec.pop_back(); // delete the big element from the queue
            }
            dec.push_back(num); // add the num

            while(!inc.empty() && num < inc.back()){ // new ele is smaller than back element
                inc.pop_back(); // delete the small element from the queue
            }
            inc.push_back(num); // add into queue the new element

            while(dec.front() - inc.front() > limit){
                if(dec.front() == nums[left]){
                    dec.pop_front();
                }
                if(inc.front() == nums[left]){
                    inc.pop_front();
                }
                left++; // continously moving the left pointer
            }
            ans = max(ans, right - left + 1);
        }
        return ans;
    }
};