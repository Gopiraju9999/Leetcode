class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        int n = s.length();

        for(int i = 0; i < n; i++){
            s = s.substring(1) + s.charAt(0);

            if(s.equals(goal))
                return true;
        }
        return false;
    }
}