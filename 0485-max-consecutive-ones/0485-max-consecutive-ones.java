class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int i = 0, count = 0, maxi = 0;

        for(int j = 0; j < n; j++){
            if(nums[j] == 1)
                count++;
                maxi = Math.max(maxi, count);
            if(nums[j] == 0)
                count = 0;
        }
        return maxi;
    }
}