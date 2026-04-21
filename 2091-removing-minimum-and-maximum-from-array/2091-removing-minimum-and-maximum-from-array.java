class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max_idx = 0, min_idx = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < nums[min_idx]){
                min_idx = i;
            }else if(nums[max_idx] < nums[i]){
                max_idx = i;
            }
        }
        int l = Math.min(max_idx, min_idx);
        int r = Math.max(max_idx, min_idx);

        int case1 = (r + 1);
        int case2 = (n - l);
        int case3 = (l + 1) + (n - r);

        return Math.min(case1, Math.min(case2, case3));
    }
}