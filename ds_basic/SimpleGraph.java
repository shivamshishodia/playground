import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleGraph {

    // Declare an adjacency list.
    LinkedList<Integer> adj[];
    int V;

    // Initialize the adjacency list.
    @SuppressWarnings("unchecked")
    SimpleGraph(int v) {
        this.V = v;
        adj = new LinkedList[this.V];
        for (int i = 0; i < this.V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    // Add to the adjacency list of that vertex.
    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // Traverse the graph BFS.
    void BFS(int source) {
        // Initialize the visited array.
        int visited[] = new int[V];
        Arrays.fill(visited, 0);

        // Create a FIFO queue and mark the source as visited.
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[source] = 1;

        // Add the source to queue.
        queue.add(source);

        // Traverse layer by layer.
        while (!queue.isEmpty()) {
            int ele = queue.poll();
            System.out.print(ele + " ");
            // Traverse adjacency list
            Iterator<Integer> itr = adj[ele].listIterator();
            while (itr.hasNext()) {
                int i = itr.next();
                // If the vertex if not visted already.
                if (visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }
    }

    // Traverse the graph DFS helper.
    void DFSUtil(int ele, boolean visited[]) {
        // Mark the node as visited.
        visited[ele] = true;
        System.out.print(ele + " ");
        // Keep adding associated nodes.
        Iterator<Integer> itr = adj[ele].listIterator();
        while (itr.hasNext()) {
            int node = itr.next();
            // Visit only unvisted nodes.
            if (!visited[node]) {
                DFSUtil(node, visited);
            }
        }
    }

    // Traverse the graph DFS.
    void DFS(int ele) {
        // Mark all nodes as not visited.
        boolean visited[] = new boolean[V];
        // Call the helper.
        DFSUtil(ele, visited);
    }

    public static void main(String[] args) {
        /**
         *   0 ------> 1
         *  ( )      .
         *  ( )   .   
         *  ( ) .     ( )
         *   2 ------> 3 
         */
        SimpleGraph g = new SimpleGraph(4);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.print("BFS : ");
        g.BFS(2);
        System.out.println("");

        System.out.print("DFS : ");
        g.DFS(2);
        System.out.println("");
    }
}
