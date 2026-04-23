class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer>st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < 2*n; i++){
            int curr_idx = i % n;

            while(!st.isEmpty() && nums[curr_idx] > nums[st.peek()]){
                int idx = st.pop();
                result[idx] = nums[curr_idx];
            }
            if(i < n){
                st.push(curr_idx);
            }
        }
        return result;
    }
}