class Solution {
public:
    int finalPositionOfSnake(int n, vector<string>& commands) {
       int i = 0, j = 0;
       for(string cmd : commands){
        if(cmd == "UP") i -= 1;
        else if(cmd == "DOWN") i += 1;
        else if(cmd == "LEFT") j -= 1;
        else if(cmd == "RIGHT") j +=1;
       } 
       int ans = (i*n)+j;
       return ans; // selects the current stopped position in 2D matrix
    }
};