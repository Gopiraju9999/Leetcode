class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int p = 0, s = 0;

        for(int i = 0; i < n; i++){
            p += nums[i];
            prefix[i] = p;

            s += nums[n-1-i];
            suffix[n-1-i] = s;
        }

        for(int i = 0; i < n; i++){
            if(prefix[i] == suffix[i]){
                return i;
            }
        }
        return -1;
    }
}