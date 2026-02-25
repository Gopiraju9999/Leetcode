class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer>mpp = new HashMap<>();

        for(char ch : s.toCharArray()){
            mpp.put(ch, mpp.getOrDefault(ch, 0)+1);
        }

        for(int i = 0; i < s.length(); i++){
            if(mpp.get(s.charAt(i)) == 1){  // Fetches the element from Map, whose frequency "1"
                return i;
            }
        }
        return -1;
    }
}