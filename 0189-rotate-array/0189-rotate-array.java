class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        reverse(nums, 0, n-1); // Reverse Complete Array..
        reverse(nums, 0, k-1); // Reverse "K" sized Array..
        reverse(nums, k, n-1); // Reverse remaining Array..
    }
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }  
}