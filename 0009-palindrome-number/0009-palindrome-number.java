class Solution {
    public boolean isPalindrome(int x) {
        int reversed = 0, original = x;

        while(x > 0){
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        if(original == reversed){
            return true;
        }
        return false;
    }
}