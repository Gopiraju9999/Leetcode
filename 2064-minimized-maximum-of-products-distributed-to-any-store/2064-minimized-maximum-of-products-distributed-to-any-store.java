class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int ans = -1;
        int low = 1, high = FindMax(quantities);

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(FindMini(mid, quantities) <= n){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private int FindMax(int[] quantities){
        int n = quantities.length;
        int maxi = quantities[0];

        for(int i = 1; i < n; i++){
            maxi = Math.max(maxi, quantities[i]);
        }
        return maxi;
    }
    private int FindMini(int n, int[] quantities){
        int m = quantities.length;
        int sum = 0;
        for(int i = 0; i < m; i++){
            sum += (quantities[i] + n - 1) / n;
        }
        return sum;
    }
}