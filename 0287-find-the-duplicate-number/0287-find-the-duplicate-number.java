class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer>mpp = new HashMap<>();

        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0)+1);
            if(mpp.get(num) > 1){
                return num;
            }
        }
        return -1;
    }
}