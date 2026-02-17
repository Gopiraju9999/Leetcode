class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Stack<Integer>st = new Stack<>();
        Map<Integer, Integer>mpp = new HashMap<>();
        
        // Store them into stack, According to the next greater element..
        for(int num : nums2){
            while(!st.isEmpty() && num > st.peek()){
                mpp.put(st.pop(), num);
            }
            st.push(num);
        }
        // Rest of the elements, assign them to "-1"
        while(!st.isEmpty()){
            mpp.put(st.pop(), -1);
        }

        int[] result = new int[n1];
        Arrays.fill(result, -1);
        for(int i = 0; i < n1; i++){
            result[i] = mpp.get(nums1[i]);  // "Get" automatically calls the value{key, value}
        }
        
        return result;
    }
}