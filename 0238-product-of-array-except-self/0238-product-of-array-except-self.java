class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        for(int i = 1; i < n; i++){
            result[i] = nums[i-1] * result[i-1];
        }

        int right_prod = 1;
        for(int r = n-1; r >= 0; r--){
            result[r] = result[r] * right_prod;
            right_prod *= nums[r];
        }
        return result;
    }
}