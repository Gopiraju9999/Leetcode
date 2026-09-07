class Solution {
    // For every element in given array, try to get the Previous smaller & Next smaller element
    // Because, After getting them both 
    // simpily calculating the minimum subarrays of current element
    // Taking those indices & multiplying to get existing subaarys
    public int sumSubarrayMins(int[] arr) {
        int[] nse = NSE(arr);
        int[] pse = PSE(arr);
        long total = 0;
        int mod = (int)(1e9+7);

        for(int i = 0; i < arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (total + (long) left * right * arr[i]) % mod;
        }
        return (int)total;
    }
    // Way to solve the "next smaller element" 
    private int[] NSE(int[] arr){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int[] nse = new int[n];

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            // If the NSE hasn't in the array, add the length of array else top element
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    // Way to find the "Previous smaller element"
    private int[] PSE(int[] arr){
        int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int[] pse = new int[n];

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}