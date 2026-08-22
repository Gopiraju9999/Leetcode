class Solution {
    public int longestOnes(int[] nums, int k) {
        // Sliding window approach
        // window keep going forward, if element is "0" increment zerocount++
        // Because, it's useful for considering "k" elements into window
        int n = nums.length;
        int i = 0, maxi = Integer.MIN_VALUE, zero_count = 0;

        for(int j = 0; j < n; j++){
            // zero found increment the zero count
            if(nums[j] == 0) zero_count++;

            // If the window has more than "k" zeroes. Shrink the window..
            while(zero_count > k){
                // Decrease the zerocount if the i pointer found "0"
                if(nums[i] == 0){
                    zero_count--;
                }
                i++;
            }
            maxi = Math.max(maxi, j-i+1);
        }
        return maxi;
    }
}