class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posi_idx = 0;
        int negi_idx = 1;

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                result[posi_idx] = nums[i];
                posi_idx += 2;
            }else{
                result[negi_idx] = nums[i];
                negi_idx += 2;
            }
        }
        return result;
    }
}