class Solution {
    public int totalFruit(int[] fruits) {
        // Sliding window approach..
        // Keep moving the pointers forward unill the window having 2 distinct values..
        // when the map having "> 2 distnict values", shrink the window and keep maximum aswell
        // return maximum 
        int n = fruits.length;
        Map<Integer, Integer>mpp = new HashMap<>();
        int i = 0, maxi = 0;

        for(int j = 0; j < n; j++){
            mpp.put(fruits[j], mpp.getOrDefault(fruits[j], 0)+1);

            while(mpp.size() > 2){
                // Decrement the frequency of element
                mpp.put(fruits[i], mpp.get(fruits[i]) -1);

                // Removing the element from the map
                if(mpp.get(fruits[i]) == 0){
                    mpp.remove(fruits[i]);
                }
                i++;
            }
            maxi = Math.max(maxi, j-i+1);
        }
        return maxi;
    }
}