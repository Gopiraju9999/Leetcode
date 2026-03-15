class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer>mpp = new HashMap<>();
        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        List<Integer>lt = new ArrayList<>();
        for(Map.Entry<Integer, Integer>entry : mpp.entrySet()){
            if(entry.getValue() > n/3){
                lt.add(entry.getKey());
            }
        }
        return lt;
    }
}