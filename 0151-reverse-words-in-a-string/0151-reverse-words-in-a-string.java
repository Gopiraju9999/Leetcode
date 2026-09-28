class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int start = 0;

        Reverse(arr, 0, n-1);

        for(int i = 0; i <= n; i++){
            if(i == n || arr[i] == ' '){
                int left = start, right = i-1;

                while(left < right){
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;

                    left++;
                    right--;
                }
                start = i+1;
            }
        }  
        return new String(arr).trim().replaceAll("\\s+", " ");
    }
    public void Reverse(char[] arr, int left, int right){
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}