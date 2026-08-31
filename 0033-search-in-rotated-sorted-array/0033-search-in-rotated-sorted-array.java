class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }

            // Important concept..
            // Check the part(low to mid) is sorted or not
            // If sorted then check only between that range
            if(nums[low] <= nums[mid]){
                // Checking in that range[low -> mid], if yes move high backward
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            // After checking above condition low moves forward.
            // Now, again check the part is sorted or not..
            // check If between range[mid -> high]
            else{
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}