class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]>q = new LinkedList<>();

        // Original color means storing the initial value in [sr][sc] pixel
        // ex:- img[sr][sc] = 1 so, original color is "1"
        // If my original color & color is same. It means no need to do anything
        int original_color = image[sr][sc];

        if(original_color == color){
            return image;
        }
        
        // Initially, add the "sr,sc" node into queue and make it colored..
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        // These are possible directions to move (up, down, left, right)
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(!q.isEmpty()){
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];

                for(int[] dir : directions){
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    // These are the possible conditions need to make the pixel as colored
                    if(isValid(new_i, new_j, m, n) && image[new_i][new_j] == original_color){
                        image[new_i][new_j] = color;
                        q.offer(new int[]{new_i, new_j});
                    }
                }
        }
        return image;
    }
    private boolean isValid(int i, int j, int m, int n){
        
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}