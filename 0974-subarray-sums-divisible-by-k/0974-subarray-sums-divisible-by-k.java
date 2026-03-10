class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer>mpp = new HashMap<>();
        mpp.put(0,1);
        int count = 0, prefix_sum = 0;

        for(int num : nums){
            prefix_sum += num;

            int remainder = prefix_sum % k;
            if(remainder < 0) remainder += k;
            
            if(mpp.containsKey(remainder)){
                count += mpp.get(remainder);
            }
            mpp.put(remainder, mpp.getOrDefault(remainder, 0)+1);
        }
        return count;
    }
}