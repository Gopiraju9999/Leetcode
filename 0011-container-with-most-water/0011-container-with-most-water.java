class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int Maxi = 0, i = 0, j = n-1;

        while(i < j){
            // Capacity formulae.. Length * breadth & keep tracking maximum as well..
            int capacity = Math.min(height[i], height[j]) * Math.abs(i - j);
            Maxi = Math.max(Maxi, capacity);

            // Moving pointers forward or backward according to "> or <"
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return Maxi;
    }
}