class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // MinHeap Keeps the smallest elements at top..
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.offer(num);

            if(minHeap.size() > k) minHeap.poll();
        }        
        return minHeap.peek();
    }
}