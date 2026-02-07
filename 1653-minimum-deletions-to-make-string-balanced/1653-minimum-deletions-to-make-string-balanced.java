class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int res = 0, b = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == 'b'){
                b++;
            }else if(b > 0){
                res++;
                b--;
            }
        }
        return res;
    }
}