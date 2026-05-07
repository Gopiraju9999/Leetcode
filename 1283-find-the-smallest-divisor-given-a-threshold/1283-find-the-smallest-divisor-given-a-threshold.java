class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = -1;
        int low = 1, high = FindMinMax(nums);
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(CheckDivisor(nums, mid) <= threshold){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private int FindMinMax(int[] nums){
        int n = nums.length;
        int maxi = nums[0];

        for(int i = 1; i < n; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }
    private int CheckDivisor(int[] nums, int div){
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += (nums[i] + div - 1) / div;
        }
        return sum;
    }
}