class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer>mpp = new HashMap<>();
        
        // Initially all the elements into Map and count their frequencies..
        for(String word : words){
            mpp.put(word, mpp.getOrDefault(word, 0) + 1);
        }

        // Way to Creating the Minimum Heap. Because, it priorities lowest frequencies first
        // It follows the "lowest frequency first", In case..
        // Frequencies has same then it follow ups the Alphabetical order
        PriorityQueue<String>MinHeap = new PriorityQueue<>((a,b) -> {
            if(!mpp.get(a).equals(mpp.get(b))){
                return mpp.get(a) - mpp.get(b);
            }
            return b.compareTo(a);
        });

        // Keep storing elements one by one into heap 
        // If same one comes, increase the frequency or if it's a new one add like new
        for(String word : mpp.keySet()){
            MinHeap.offer(word);

            // When we reach the bound{limit} removes the first(lowest frequency) element 
            if(MinHeap.size() > k){
                MinHeap.poll();
            }
        }

        List<String>result = new ArrayList<>();
        while(!MinHeap.isEmpty()){
            result.add(MinHeap.poll());
        }
        // Order which is having "Ascending order". So, we should make it as "Decresing order"
        Collections.reverse(result);

        return result;
    }
}