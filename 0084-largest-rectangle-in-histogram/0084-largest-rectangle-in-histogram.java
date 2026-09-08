class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer>st = new Stack<>();
        int[] pse = new int[n];
        int[] nse = new int[n];

        // Previous Smaller element
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            // Here stack is empty means nothing smaller element in left side.. so take "-1"
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // Next Smaller Element
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            // Here st is empty means nothing smaller element at right side.. so take length(n).
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Way to calculate 
        int maxi = 0;
        for(int i = 0; i < n; i++){
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            maxi = Math.max(maxi, area);
        }
        return maxi;
    }
}