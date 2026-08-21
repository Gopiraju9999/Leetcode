class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Approach..
        // Store all elements into map{element, index}
        // If the current element exist in map. Then, store the index of that element..
        // Now compare previous & current element index
        // If <= k return true,otherwise false;

        int n = nums.length;
        Map<Integer, Integer>mpp = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(mpp.containsKey(nums[i])){
                int prev_idx = mpp.get(nums[i]);

                if(i - prev_idx <= k) return true;
            }
            mpp.put(nums[i], i);
        }
        return false;
    }
}