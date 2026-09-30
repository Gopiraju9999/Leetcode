class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return Atmost(nums, k) - Atmost(nums, k-1);
    }

    private int Atmost(int[] nums, int k){
        int n = nums.length;
        int i = 0, oddnum_count = 0, subarray_count = 0;

        for(int j = 0; j < n; j++){

            if(nums[j] % 2 == 1){
                oddnum_count++;
            }

            while(oddnum_count > k){

                if(nums[i] % 2 == 1){
                    oddnum_count--;
                }
                i++;
            }
            subarray_count += j-i+1;
        }
        return subarray_count;
    }
}