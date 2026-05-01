class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = FirstPosition(nums, target, nums.length);
        //if(first == -1) return new int[]{-1, -1};
        int last = LastPosition(nums, target, nums.length);
        return new int[]{first, last};
    }
    // For searching the first occurancesss..
    private int FirstPosition(int[] nums, int target, int n){
        int first = -1;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return first;
    }
    // For searching the last occurancesss..
    private int LastPosition(int[] nums, int target, int n){
        int last = -1;
        int low = 0, high = n-1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target) low = mid +1;
            else high = mid - 1;
        }
        return last;
    }
}