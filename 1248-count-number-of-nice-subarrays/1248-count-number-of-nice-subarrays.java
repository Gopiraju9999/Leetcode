class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return Atmost(nums, k) - Atmost(nums, k-1);
    }

    private int Atmost(int[] nums, int k){
        int n = nums.length;

        int i = 0, res = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] % 2 == 1) k--;

            while(k < 0){
                if(nums[i] % 2 == 1) k++;
                i++;
            }
            
            res += (j-i+1);
        }
        return res;
    }
}