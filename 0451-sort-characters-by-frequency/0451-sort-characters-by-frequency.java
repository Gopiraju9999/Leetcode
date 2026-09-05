class Solution {
    public String frequencySort(String s) {
        // Store elements in Map, It stores like {key, value}
        // Integrate the Priority queue, it keeps at top the maximum frequency ones
        // Remove the top element from PQ, add into string till the frequency gets "0"

        int n = s.length();
        Map<Character, Integer>mpp = new HashMap<>();

        // It stores all elements into Map..
        for(char ch : s.toCharArray()){
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        // Implement the priority queue MaxHeap (Keeps top element at top)
        PriorityQueue<Map.Entry<Character, Integer>>pq = 
        new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        // Way to storing the elements into PQ through Map
        for(Map.Entry<Character, Integer>entry : mpp.entrySet()){
            pq.offer(entry);
        }

        // String for storing the characters
        StringBuilder result = new StringBuilder();
        // Till the PQ gets empty
        while(!pq.isEmpty()){
            // Remove the top one from PQ
            Map.Entry<Character, Integer>entry = pq.poll();
            char ch = entry.getKey();   // Key which in the form of character
            int freq = entry.getValue(); // Value, which is in the form of numbers (frequency)

            // Run the loop & adding the character till equals to frequency
            for(int i = 1; i <= freq; i++){
                result.append(ch);
            }
        }
        return result.toString();
    }
}