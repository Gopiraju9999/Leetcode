class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            int new_idx = (i + nums[i]) % n;

            if(new_idx < 0){
                new_idx += n;
            }
            
            result[i] = nums[new_idx];
        }
        return result;
    }
}