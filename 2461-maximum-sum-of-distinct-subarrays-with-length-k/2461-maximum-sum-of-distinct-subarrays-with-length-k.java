class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer>st = new HashSet<>();
        long sum = 0, maxi_sum = 0;

        int i = 0; 
        for(int j = 0; j < n; j++){

            // Check the element present in set or not??
            while(st.contains(nums[j])){
                st.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            // element is not present in set. Then, add into set
            st.add(nums[j]);
            sum += nums[j];

            // Now, my current window size is "k-sized". Calculate the maximum & shrink window
            if(j-i+1 == k){
                maxi_sum = Math.max(maxi_sum, sum);
                st.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return maxi_sum;
    }
}