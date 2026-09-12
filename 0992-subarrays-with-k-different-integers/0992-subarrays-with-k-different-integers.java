class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return AtMost(nums, k) - AtMost(nums, k-1);
    }
    
    private int AtMost(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer>mpp = new HashMap<>();
        int i = 0, subarray_cnt = 0;

        for(int j = 0; j < n; j++){

            // Keep adding elements into map
            mpp.put(nums[j], mpp.getOrDefault(nums[j], 0) + 1);

            // When my map has more than "k-different" elements
            // Decrement the frequency of element
            while(mpp.size() > k){
                mpp.put(nums[i], mpp.get(nums[i]) - 1);
                // Or, If that element has "0-frequency". Then remove the element from map
                // and also move forward
                if(mpp.get(nums[i]) == 0){
                    mpp.remove(nums[i]);
                }
                i++;
            }

            subarray_cnt += j-i+1;
        }
        return subarray_cnt;
    }
}