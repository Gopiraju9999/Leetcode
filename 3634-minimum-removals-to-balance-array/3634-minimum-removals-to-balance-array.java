class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;

        int j = 0, maxi = 0;

        for(int i = 0; i < n; i++){
            while(j < n && nums[j] <= (long)nums[i] * k){
                j++;
            }
            maxi = Math.max(maxi, j-i);
        }
        return n - maxi;
    }
}