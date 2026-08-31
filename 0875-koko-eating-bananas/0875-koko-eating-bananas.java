class Solution {
    
    // For every Binary Search on Answers type of problems. We should follow 3 steps:
    // Step1: Finding mini & maxi for doing Binary Search operations..
    // Step2: It's heart of problem, doing calulations according to problem. Run a loop in the given array and do calculations "with the presence of mind".
    // Step3: It's nothing.. Take range from mini to maxi in the array and perform operation
    // Brute force : Linear search for answers 0(n), optimal : Binary search for answers 0(logn)
    // Be Careful with supportive functions..

    private int FindMax(int[] piles){
        int maxi = 0;
        for(int pile : piles){
            if(pile > maxi){
                maxi = pile;
            }
        }
        return maxi;
    }

    private boolean canEat(int[] piles, int h, int k){
        long hours = 0;

        for(int i = 0; i < piles.length; i++){
            hours += Math.ceil((double) piles[i] / k);

            if(hours > h) return false;
        }
        return true;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = FindMax(piles), result = high; // Initially, took higher for safety

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canEat(piles, h, mid)){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
}