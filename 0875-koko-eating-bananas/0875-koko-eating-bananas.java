class Solution {
    private int FindMax(int[] piles){
        int max = 0;
        for(int pile : piles){
            if(pile > max)
                max = pile;
        }
        return max;
    }

    private boolean canEat(int[] piles, int h, int k){
        long hours = 0;

        for(int i = 0; i < piles.length; i++){
            hours += Math.ceil((double)piles[i] / k);

            if(hours > h) return false;
        }
        return true;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = FindMax(piles), result = high;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canEat(piles, h, mid)){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
}