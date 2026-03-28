class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return Atmost(nums, goal) - Atmost(nums, goal-1);
    }
    private int Atmost(int[] nums, int goal){
        int n = nums.length;

        if(goal < 0) return 0;

        int i = 0, j = 0,count = 0, res = 0;
        while(j < n){
            count += nums[j];

            while(count > goal){
                count -= nums[i];
                i++;
            }
            res += (j-i+1);
            j++;
        }
        
        return res;
    }
}