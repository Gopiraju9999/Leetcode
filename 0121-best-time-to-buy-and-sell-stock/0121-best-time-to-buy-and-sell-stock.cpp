class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minprice = prices[0]; // Assuming 1st element as low
        int maxprofit =0;
        for(int i=1; i<prices.size(); i++){
            int cost= prices[i]-minprice;
            maxprofit=max(maxprofit, cost);
            minprice=min(minprice, prices[i]); // Compare the past & current Prices
        }
        return maxprofit;
    }
};