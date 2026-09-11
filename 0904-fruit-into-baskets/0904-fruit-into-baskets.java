class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer>mpp = new HashMap<>();
        int maxi_fruits = 0;
        int i = 0;

        for(int j = 0; j < n; j++){
            
            // Add every element into map
            mpp.put(fruits[j], mpp.getOrDefault(fruits[j], 0) + 1);
        
         // Here the condition we need to shrink the window
            while(mpp.size() > 2){
                
                // Decrement & Remove the first element (ith) from map
                mpp.put(fruits[i], mpp.get(fruits[i]) - 1);
                if(mpp.get(fruits[i]) == 0){
                    mpp.remove(fruits[i]);
                }
                i++;
            }
            maxi_fruits = Math.max(maxi_fruits, j-i+1);
        }
        return maxi_fruits;
    }
}