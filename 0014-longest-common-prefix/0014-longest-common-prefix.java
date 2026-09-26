class Solution {
    public String longestCommonPrefix(String[] strs) {
        // After sorting, in string based problems the array of string looks like in order
        // Order means smallest length string at 1st largest length string at last like that..
        
        // To returning the string as output
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs); 

        // After sorting, array follows the ascending order
        // Start checking the first & last strings charcaters
        // If any of the character mismatches then stop checking and return the string
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        for(int i = 0; i < first.length; i++){
            if(first[i] != last[i]){
                break;
            }
            result.append(first[i]);    // Add into string the matched characters
        }
        return result.toString();
    }
}