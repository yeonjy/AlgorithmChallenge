import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        HashMap<String, Node> child;
        public Node() {
            this.child = new HashMap<>();
        }
    }

    static class Trie {
        Node root;
        public Trie() {
            this.root = new Node();
        }

        public void insert(List<String> words) {
            Node node = this.root;
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                node.child.putIfAbsent(word, new Node());
                node = node.child.get(word);
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Trie trie = new Trie();
        List<String>[] ways = new List[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ways[i] = new ArrayList<>();
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                ways[i].add(st.nextToken());
            }
            // Trie에 넣기
            trie.insert(ways[i]);
        }
        // node 방문하면서 출력
        dfs(trie.root, 0);
        System.out.println(sb);
    }

    static void dfs(Node node, int depth) {
        HashMap<String, Node> next = node.child;
        if (next.isEmpty()) {
            return;
        }
        List<String> tmp = new ArrayList<>(next.keySet());
        Object[] array = tmp.stream().sorted().toArray();

        for (Object now : array) {
            for (int i = 0; i < depth * 2; i++) {
                sb.append("-");
            }
            sb.append(now).append("\n");
            dfs(next.get((String) now), depth + 1);
        }
    }
}
