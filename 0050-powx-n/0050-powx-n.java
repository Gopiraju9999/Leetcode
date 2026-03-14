class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if(N == 0) return 1; // Anything power "0"
        if(N < 0){
            N = -N;
            x = 1.0 / x;
        }
        if(N % 2 == 0){
            return myPow(x * x , (int)(N/2));
        }
        return x * myPow(x, (int)(N-1));
    }
}