class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int boats = 0, i = 0, j = n-1;

        while(i <= j){
            // Exist condition..
            if(people[i] + people[j] <= limit){
                i++;
                j--;
            }
            // Here it goes beyond Then, decrement "j". Because, "j" pointing greater one..
            else{  
                j--;
            }
            boats++;
        }
        return boats;
    }
}