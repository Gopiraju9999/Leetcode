class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String>minHeap = new PriorityQueue<>((a,b) -> {
            if(a.length() != b.length()){
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        for(String num : nums){
            minHeap.offer(num);

            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}