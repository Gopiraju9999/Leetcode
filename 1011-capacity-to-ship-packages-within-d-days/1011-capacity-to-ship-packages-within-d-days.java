class Solution {

    // Here capacity means calculated mid in BSearch..
    // The function returns the required days to finish work
    // If it works simpily store the exist value, if not move forward for heavy load per day..
    private int PossibleCapacity(int[] weights, int capacity){ 
        int days = 1, curr_load = 0;

        for(int wei : weights){
            if(curr_load + wei > capacity){
                days++;
                curr_load = wei;
            }else{
                curr_load += wei;
            }
        }
        return days;
    }

    // Implement Bsearch the range between maximum value & sum of all values in array..
    public int shipWithinDays(int[] weights, int days) {
        // It directly fetches the maximum & sum of all elements
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low < high){
            int mid = low + (high - low) / 2;
            int needed_capacity = PossibleCapacity(weights, mid);

            // If the needed days to finish loads shouls be less than or equal to given days..
            if(needed_capacity <= days){
                // Move backward for minimum capacity
                high = mid;
            }else{
                // Move forward for maximum capacity
                low = mid + 1;
            }
        }
        return low;
    }
}