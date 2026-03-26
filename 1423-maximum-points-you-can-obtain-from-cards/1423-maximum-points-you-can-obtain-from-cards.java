class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int total_sum = 0;
        for(int card : cardPoints){
            total_sum += card;
        }

        if(n == k) return total_sum;

        int left_sum = 0;
        for(int i = 0; i < k; i++){
            left_sum += cardPoints[i];
        }

        int right_sum = 0, max_sum = left_sum;
        for(int j = 1; j <= k; j++){
            left_sum -= cardPoints[k - j];
            right_sum += cardPoints[n - j];
            max_sum = Math.max(max_sum, left_sum + right_sum);
        }
        return max_sum;
    }
}