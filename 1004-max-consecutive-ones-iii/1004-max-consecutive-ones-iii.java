class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0, maxi = 0, zero_count = 0;

        for(int j = 0; j < n; j++){
            if(nums[j] == 0){
                zero_count++;
            }
            // Here, the window has maximum zeros. Stop here and find the length
            while(zero_count > k){ 
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