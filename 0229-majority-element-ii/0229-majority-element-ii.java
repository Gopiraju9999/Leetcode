class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>mpp =  new HashMap<>();
        List<Integer>result = new ArrayList<>();

        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);

            if(mpp.get(num) > n/3 && !result.contains(num)){
                result.add(num);
            }
        }
        return result;
    }
}