class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");  // Removes the starting and ending spaces..

        int left = 0, right = arr.length - 1;

        while(left < right){
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return String.join(" ", arr);   
    }
}