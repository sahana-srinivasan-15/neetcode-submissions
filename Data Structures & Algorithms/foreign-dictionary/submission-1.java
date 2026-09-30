class Solution {

    public List<Integer> topoSort(int k, List<List<Integer>> adj) {

        int[] indegree = new int[k];

        for (int i = 0; i < k; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {

            int curr = q.poll();
            topo.add(curr);

            for (int n : adj.get(curr)) {
                indegree[n]--;

                if (indegree[n] == 0) {
                    q.add(n);
                }
            }
        }

        return topo;
    }

    public String foreignDictionary(String[] words) {

        int k = 26;

        boolean[] present = new boolean[26];

        int count = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!present[c - 'a']) {
                    present[c - 'a'] = true;
                    count++;
                }
            }
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            // Invalid prefix
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < len; ptr++) {

                if (s1.charAt(ptr) != s2.charAt(ptr)) {

                    int u = s1.charAt(ptr) - 'a';
                    int v = s2.charAt(ptr) - 'a';

                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                    }

                    break;
                }
            }
        }

        List<Integer> topo = topoSort(k, adj);

        // Cycle detection
        int visitedCount = 0;

        for (int node : topo) {
            if (present[node]) {
                visitedCount++;
            }
        }

        if (visitedCount != count) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int node : topo) {
            if (present[node]) {
                sb.append((char) (node + 'a'));
            }
        }

        return sb.toString();
    }
}