class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int i = 0, min_length = Integer.MAX_VALUE, count = 0;

        for(int j = 0; j < n; j++){
            count += nums[j];

            while(count >= target){
                min_length = Math.min(min_length, j-i+1);
                count -= nums[i];
                i++;
            }
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}