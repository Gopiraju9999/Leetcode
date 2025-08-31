class Solution {
public:
    double myPow(double x, int n) {
        long N = n;
        if(N == 0) return 1; // anything power "0" is 1
        if(N < 0){
            N = -N;
            x = 1.0 / x;
        }
        if(N % 2 == 0){
            return myPow(x * x, N/2);
        }
        return x * myPow(x,N-1); // current value * smaller problems
    }
};