class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int maxi = 0, mini = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < nums[mini]){
                mini = i;
            }else if(nums[maxi] < nums[i]){
                maxi = i;
            }
        }
        int l = Math.min(maxi, mini);
        int r = Math.max(maxi, mini);

        int case1 = (r + 1);
        int case2 = (n - l);
        int case3 = (l + 1) + (n - r);

        return Math.min(case1, Math.min(case2, case3));
    }
}