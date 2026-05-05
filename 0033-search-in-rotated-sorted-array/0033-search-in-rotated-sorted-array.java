class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            // If my target found, simply return it..
            if(nums[mid] == target){
                return mid;
            }
            // compare the elements in array. Is it left rotated or right??
            if(nums[low] <= nums[mid]){ // It justifies, which part rotated, Left Sorted/rotated
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{      // Another option is Right Sorted/rotated..
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}