class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer>mpp = new HashMap<>();

        for(int num : nums){
            if(num % 2 == 0)
                mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        int MaxFreq = 0, MaxValue = -1;

        for(Map.Entry<Integer, Integer>entry : mpp.entrySet()){ // Run into Map
            int num = entry.getKey();
            int freq = entry.getValue();

            if(freq > MaxFreq || (freq == MaxFreq && num < MaxValue)){
                MaxFreq = freq;
                MaxValue = num;
            }
        }
        return MaxValue;
    }
}