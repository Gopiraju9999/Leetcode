class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mpp1 = new HashMap<>();
        Map<Character, Character> mpp2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mpp1.containsKey(c1)){
                if(mpp1.get(c1) != c2) return false;
            }else{
                mpp1.put(c1, c2);
            }

            if(mpp2.containsKey(c2)){
                if(mpp2.get(c2) != c1) return false;
            }else{
                mpp2.put(c2, c1);
            }
        }
        return true;
    }
}