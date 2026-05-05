class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0, high = nums.size()-1;
        
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] <= nums[mid]){ // left sorted(low is lower than the mid)
                if(nums[low] <= target && target < nums[mid]){ //4<=target<=mid
                    high = mid-1;                       // move low side
                }else{
                    low = mid+1;
                }
            }
            else{ // right sorted
                if(nums[mid]<target && target<= nums[high]){ //mid<=target<=high
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
};