class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>>mpp = new HashMap<>();

        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String key = new String(ch);

            mpp.putIfAbsent(key, new ArrayList<>()); // If absent add new list..
            mpp.get(key).add(s);        // Adding string as per the sorted manner in list
        }
        return new ArrayList<>(mpp.values());
    }
}