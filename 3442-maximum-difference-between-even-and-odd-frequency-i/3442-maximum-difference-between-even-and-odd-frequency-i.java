class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        Map<Character, Integer>mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0)+1);
        }

        int mini_even = Integer.MAX_VALUE, maxi_odd = Integer.MIN_VALUE;

        for(char ch : mpp.keySet()){
            int freq = mpp.get(ch);
            if(freq % 2 == 0){
                mini_even = Math.min(mini_even, freq);
            }else{
                maxi_odd = Math.max(maxi_odd, freq);
            }
        }
        return maxi_odd - mini_even;
    }
}