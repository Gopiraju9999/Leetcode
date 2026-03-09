class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Creating Adjacency List..

        List<List<int[]>>adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{src, 0});     // {node, distance}

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;      // The source node having "0" distance
        int s = 0;

        while(!q.isEmpty()){
            int size = q.size();

            if(s > k) break;        // Reached "K - stops" then went out..

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();      // Assigning values in Queue..
                int node = curr[0];
                int weight = curr[1];

                for(int[] nei : adj.get(node)){   // Loop for current one neighbours..
                    int adj_node = nei[0];
                    int edge_weight = nei[1];

                    if(weight + edge_weight < dist[adj_node]){
                        dist[adj_node] = weight + edge_weight;
                        q.offer(new int[]{adj_node, dist[adj_node]});
                    }
                }
            }
            s++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}