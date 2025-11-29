class Solution {
public:
    void dfs(vector<vector<int>>& image, int i, int j,int val, int newColor)
    {
        if(i<0 || i>=image.size() || j<0 || j>= image[0].size() || image[i][j] == newColor || 
        image[i][j] != val)
        {
            return;
        }
        image[i][j] = newColor;
        dfs(image,i-1,j,val,newColor); // TOP
        dfs(image,i+1,j,val,newColor); // DOWN
        dfs(image,i,j-1,val,newColor); // LEFT
        dfs(image,i,j+1,val,newColor); // RIGHT
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newcolor) {
        int val = image[sr][sc];
        dfs(image, sr, sc, val, newcolor);
        return image;
    }
};