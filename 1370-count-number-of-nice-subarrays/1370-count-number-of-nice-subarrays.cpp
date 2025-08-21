class Solution {
public:
    int atMost(vector<int>& nums, int k) {
        int cnt=0, ans=0;
     for(int i=0, j=0; j<nums.size(); j++){
        if(nums[j]%2 != 0) cnt++; // if odd, increment to "1"
        while(cnt>k) // count > k, remove the front element from the window
        if(nums[i++]%2 != 0) cnt--; // if the front element is odd, decrement count as "1"
        ans += j-i+1; // number of subarrays
     }
     return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
     return atMost(nums,k) - atMost(nums,k-1);
     }
};