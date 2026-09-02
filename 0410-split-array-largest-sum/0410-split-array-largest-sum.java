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
        int low = 0;
        int high = 0;

        // "low" always keep tracking maximum element in the array
        // "high" keep adding the element for a sum..
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }

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