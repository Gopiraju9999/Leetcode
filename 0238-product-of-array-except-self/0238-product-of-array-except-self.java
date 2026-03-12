class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n]; // Initialize with "1". Because, it goes always "0"..
        prefix[0] = 1;

        int[] sufix = new int[n];
        sufix[n-1] = 1;

        for(int i = 1; i < n; i++){     // Computing prefix sum..
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i = n-2; i >= 0; i--){  // computing suffix sum..
            sufix[i] = sufix[i+1] * nums[i+1];
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i++){     // At the end, multiply the both values..
            result[i] = prefix[i] * sufix[i];
        }

        return result;
    }
}