
class Solution {

        public int countComponents(int n, int[][] edges) {

                ArrayList<Integer>[] graph = new ArrayList[n];

                        // Create adjacency list
                                for (int i = 0; i < n; i++) {
                                            graph[i] = new ArrayList<>();
                                                    }

                                                            // Build graph
                                                                    for (int[] edge : edges) {

                                                                                graph[edge[0]].add(edge[1]);
                                                                                            graph[edge[1]].add(edge[0]);
                                                                                                    }

                                                                                                            boolean[] visited = new boolean[n];

                                                                                                                    int count = 0;

                                                                                                                            // Visit every node
                                                                                                                                    for (int i = 0; i < n; i++) {

                                                                                                                                                if (!visited[i]) {

                                                                                                                                                                count++;

                                                                                                                                                                                dfs(graph, visited, i);
                                                                                                                                                                                            }
                                                                                                                                                                                                    }

                                                                                                                                                                                                            return count;
                                                                                                                                                                                                                }

                                                                                                                                                                                                                    public void dfs(ArrayList<Integer>[] graph,
                                                                                                                                                                                                                                        boolean[] visited,
                                                                                                                                                                                                                                                            int node) {

                                                                                                                                                                                                                                                                    visited[node] = true;

                                                                                                                                                                                                                                                                            for (int neighbor : graph[node]) {

                                                                                                                                                                                                                                                                                        if (!visited[neighbor]) {

                                                                                                                                                                                                                                                                                                        dfs(graph, visited, neighbor);
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                }
