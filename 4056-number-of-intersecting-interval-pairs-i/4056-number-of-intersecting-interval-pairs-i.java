class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int start_maxi = 0, end_mini = 0, count = 0;

        for(int i = 0; i < n-1; i++){    
            for(int j = i+1; j < n; j++){
               start_maxi = Math.max(intervals[i][0], intervals[j][0]);
               end_mini = Math.min(intervals[i][1], intervals[j][1]);

               if(start_maxi <= end_mini){
                    count++;
               }
            }
        }
        return count;
    }
}