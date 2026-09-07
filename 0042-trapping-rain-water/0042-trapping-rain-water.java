class Solution {
    public int trap(int[] height) {
        // Follow up the NGE approach 
        // Instead of store previous idx, try to point out the mid(popped) one..
        // top will be left boundary, right boundary is standard for width calculation
        // Continue poping the element from the stack till top > curr_element  condition

        int n = height.length;
        Stack<Integer>st = new Stack<>();
        int total_water = 0;

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && height[st.peek()] < height[i]){
                // Take the popped one as mid for good calculation
                int mid = st.pop();
                if(st.isEmpty()){
                    break;
                }
                int left = st.peek();

                // Calculate the width "(right - left - 1)""
                int width = i - left - 1;
                int water_height = Math.min(height[left], height[i]) - height[mid];

                total_water += width * water_height;
            }
            st.push(i);
        }
        return total_water;
    }
}