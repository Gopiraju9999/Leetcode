class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer>mpp = new HashMap<>();
        mpp.put(0,1);

        int count = 0, prefix_sum = 0;

        for(int num : nums){
            prefix_sum += num;

            if(mpp.containsKey(prefix_sum - k)){ // Checks value present or not??
                count += mpp.get(prefix_sum - k); // get only gets the value {key, value}
            }
            mpp.put(prefix_sum, mpp.getOrDefault(prefix_sum, 0)+1); // else add into map..
        }
        return count;
    }
}