class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return Atmost(nums, goal) - Atmost(nums, goal-1);
    }
    private int Atmost(int[] nums, int goal){
        int n = nums.length;

        if(goal < 0) return 0;

        int i = 0, sum = 0, subarray_count = 0;

        for(int j = 0; j < n; j++){
            sum += nums[j];

            while(sum > goal){
                sum -= nums[i];
                i++;
            }
            subarray_count += (j-i+1);
        }
        
        return subarray_count;
    }
}