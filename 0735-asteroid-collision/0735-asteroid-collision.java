class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer>st = new Stack<>();

        for(int num : asteroids){
            boolean destroyed = false; // "false => push", "true => not push"

            while(!st.isEmpty() && st.peek() > 0 && num < 0){
                if(Math.abs(num) > st.peek()){
                    st.pop();
                    continue;
                }else if(Math.abs(num) == st.peek()){
                    st.pop();
                    destroyed = true;
                    break;
                }else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                st.push(num);
            }
        }

        int[] result = new int[st.size()];
        int m = result.length;
        for(int j = m-1; j >= 0; j--){
            result[j] = st.pop();
        }
        return result;
    }
}