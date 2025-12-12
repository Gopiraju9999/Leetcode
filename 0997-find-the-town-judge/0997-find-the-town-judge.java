class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outgoing = new int[n + 1]; // Stores the outgoing vertex
        int[] incoming = new int[n + 1]; // stores the incoming vertex

        for(int[] t : trust){
            outgoing[t[0]]++;  
            incoming[t[1]]++;
        }

        for(int i = 1; i <= n; i++){
            if(outgoing[i] == 0 && incoming[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}