class Solution {
    public String truncateSentence(String s, int k) {
        String result = "";
        String[] arr = s.trim().split("\\s+");

        for(int i = 0; i < k; i++){
            result += arr[i];

            if(i != k-1){
                result += " ";
            }
        }
        return result;
    }
}