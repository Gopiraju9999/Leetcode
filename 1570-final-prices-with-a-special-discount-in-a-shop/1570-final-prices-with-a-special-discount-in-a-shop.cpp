class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
       vector<int> stack;
        for (int i = 0; i < prices.size(); ++i) {
            // checking for smallone at right side
            while (stack.size() && prices[stack.back()] >= prices[i]) { 
                prices[stack.back()] -= prices[i]; // replace it with (top - curr_element)
                stack.pop_back();
            }
            stack.push_back(i);
        }
        return prices; 
    }
};