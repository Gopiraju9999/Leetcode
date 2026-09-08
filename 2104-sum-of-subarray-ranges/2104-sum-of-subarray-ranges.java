class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer>st = new Stack<>();

        // I need 4 array NSE, PSE, NGE, PGE to point out the mini's & maxi's of current element
        int[] pse = new int[n];
        int[] nse = new int[n];
        int[] pge = new int[n];
        int[] nge = new int[n];

        // Calculate the "Previous Smaller element"
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // Calculate the "Next Smaller Element"
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();

        // Calculate the "Previous Greater Element"
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // Calculate the "Next Greater Element"
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long Min_sum = 0, Max_sum = 0, answer = 0;

        for(int i = 0; i < n; i++){
            Min_sum += (long)nums[i] * (nse[i] - i) * (i - pse[i]);
            Max_sum += (long) nums[i] * (nge[i] - i) * (i - pge[i]);

            answer = Max_sum - Min_sum;
        }
        return answer;
    }
}