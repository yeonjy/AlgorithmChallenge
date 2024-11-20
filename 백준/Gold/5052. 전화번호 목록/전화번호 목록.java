import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static class Node{
        HashMap<Character, Node> child;
        boolean endOfWord;

        public Node() {
            this.child = new HashMap<>();
            this.endOfWord = false;
        }
    }

    static class Trie {
        Node root;

        public Trie(){
            this.root = new Node();
        }


        public void insert(String str){
            Node node = this.root;

            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                node.child.putIfAbsent(c,new Node());
                node = node.child.get(c);
                if (node.endOfWord) {
                    flag = false;
                }
            }
            node.endOfWord = true;
        }
    }

    static String[] numbers;
    static boolean flag = true;
    static Trie trie;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            flag = true;
            N = Integer.parseInt(br.readLine());
            numbers = new String[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = br.readLine();
            }
            Arrays.sort(numbers, (String s1, String s2) -> s1.length() - s2.length());

            trie = new Trie();
            if (!check()) {
                sb.append("NO");
            } else {
                sb.append("YES");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            trie.insert(numbers[i]);
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
