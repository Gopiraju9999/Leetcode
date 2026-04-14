class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int count = 0, max_count = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                count++;
            }else if(s.charAt(i) == ')'){
                count--;
            }
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }
}