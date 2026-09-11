class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer>st = new HashSet<>();
        long sum = 0, maxi_sum = 0;

        if(n < k) return 0;

        int i = 0;
        for(int j = 0; j < n; j++){

            while(st.contains(nums[j])){
                st.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            st.add(nums[j]);
            sum += nums[j];

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