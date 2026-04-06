class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        result[n-1] = -1;
        int maxi = arr[n-1];

        for(int i = n-2; i >= 0; i--){
            result[i] = maxi;
            maxi = Math.max(maxi, arr[i]);
        }
        return result;
    }
}