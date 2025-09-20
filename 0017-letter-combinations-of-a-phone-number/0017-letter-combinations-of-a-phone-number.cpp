class Solution {
public:
    vector<string>phone = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    vector<string>result;

    void Backtrack(string &digits, int index, string current){
        // Base case
        if(index == digits.size()){
            result.push_back(current);
            return;
        }
        //Get letters for current digit
        string letters = phone[digits[index] - '0'];
        //Try each letter
        for(char c : letters){
            Backtrack(digits, index+1, current+c);
        }
    }
    vector<string> letterCombinations(string digits) {
        if(digits.empty()) return {};
        Backtrack(digits, 0, "");
        return result;
    }
};