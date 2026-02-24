class Solution {
    // It's a way to find the Maximum & Minimum in a array..
    private int[] FindMinMax(int[] bloomDay){
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;

        for(int bloom : bloomDay){
            mini = Math.min(mini, bloom);
            maxi = Math.max(maxi, bloom);
        }
        return new int[]{mini, maxi};
    }
    // Calculating number of Bouquets required..
    private boolean PossibleBouqets(int[] bloomDay, int m, int k, int day){
        int bouqets = 0;
        int count = 0;

        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;
            }else{
                bouqets += (count / k);
                count = 0;
            }
        }
        bouqets += (count / k);

        return bouqets >= m;
    }
    // Used Binary Search for Minimum days for Blooming Flowers & Reducing the Time Complexity..
    public int minDays(int[] bloomDay, int m, int k) {
        int[] range = FindMinMax(bloomDay);
        int low = range[0];
        int high = range[1];
        int ans = high;
        
        if((long)m*k > bloomDay.length) return -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(PossibleBouqets(bloomDay, m, k, mid)){
                ans = mid;
                high= mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}