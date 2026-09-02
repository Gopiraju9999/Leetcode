class Solution {
    private int PossibleSum(int[] nums, int count){
        int sum = 0, subarrays = 1;

        for(int num : nums){
            if(sum + num > count){
                subarrays++;

                sum = num;
            }else{
                sum += num;
            }
        }
        return subarrays;
    }
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low < high){
            int mid = low + (high - low) / 2;
            int required_arrays = PossibleSum(nums, mid);

            if(required_arrays <= k){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}