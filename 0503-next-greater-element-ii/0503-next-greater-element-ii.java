class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer>st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for(int i = 0; i < 2*n; i++){
            int curr_idx = i % n;     // No need to create double array. 

            while(!st.isEmpty() && nums[curr_idx] > nums[st.peek()]){
                int index = st.pop();
                result[index] = nums[curr_idx];
            }
            st.push(curr_idx);
        }
        return result;
    }
}