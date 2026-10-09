class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        // "i" pointer is fixed and it traverses till the n-2. Because, remain was left, right
        // "left" pointer is always 1 step forward to "i" pointer position
        // "right" pointer is always at end of array position
        for(int i = 0; i < n-2; i++){
            int left = i+1, right = n-1;

            // It only handles the duplicates numbers in array
            // EX: After sorting, -4,-1,-1,0,1,2. Here -1, -1 are duplicates but make move
            if(i > 0 && nums[i] == nums[i-1]) continue;

            // Whenever the left & right pointers meet eachother. Then, reset their positions
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                }
                // Here these 2 conditions will follow the 2 sum approach
                // When "sum < 0" need to add greater number than current number.
                // "sum > 0" goes beyond, need to add lower number than current number..
                else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}