class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);
        Stack<Integer>st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int prev_idx = st.pop();
                result[prev_idx] = i - prev_idx;
            }
            st.push(i);
        }
        return result;
    }
}