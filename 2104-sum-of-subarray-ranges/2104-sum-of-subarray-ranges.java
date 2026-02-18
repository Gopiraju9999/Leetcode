class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long result = 0;

        for(int i = 0; i < n; i++){
            int largest = nums[i];
            int smallest = nums[i];
            for(int j = i; j < n; j++){
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);
                result += (largest - smallest);
            }
        }
        return result;
    }
}