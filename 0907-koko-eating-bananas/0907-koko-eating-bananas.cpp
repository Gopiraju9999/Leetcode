class Solution {
public:
    bool CanEat(vector<int>& piles, int h, int k){
        double hours = 0;
        for(int pile : piles){
            hours += ceil((double)pile / k);
        }
        return hours <= h;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int low = 0, high = *max_element(piles.begin(), piles.end());
        int result = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(CanEat(piles, h, mid)){
                result = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return result;
    }
};