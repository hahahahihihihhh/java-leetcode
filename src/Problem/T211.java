package Problem;

public class T211 {

    static final int N = 26;

    static class Node {
        boolean endFlag;
        Node[] next;
        Node() {
            next = new Node[N];
        }
    }
    Node root;

    public T211() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            Node tmp = cur.next[word.charAt(i) - 'a'] != null ? cur.next[word.charAt(i) - 'a'] : new Node();
            cur.next[word.charAt(i) - 'a'] = tmp;
            cur = tmp;
        }
        cur.endFlag = true;
    }

    boolean dfs(Node root, String word, int cur) {
        if (root == null)   return false;
        if (cur == word.length()) return root.endFlag;
        if (word.charAt(cur) == '.') {
            for (int i = 0; i < N; i ++) {
                if (dfs(root.next[i], word, cur + 1))
                    return true;
            }
            return false;
        } else {
            return dfs(root.next[word.charAt(cur) - 'a'], word, cur + 1);
        }
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

}
