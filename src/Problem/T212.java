package Problem;

import java.util.*;

public class T212 {

    static final int N = 26;

    static class Node{
        boolean endFlag;
        Node[] next;
        Node() {
            next = new Node[N];
        }
    }

    int n, m;
    Set<String> ans = new HashSet<>();
    int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] vis;
    Node root = new Node();

    void insert(String word) {
        int n = word.length();
        Node cur = root;
        for (int i = 0; i < n; i ++) {
            Node tmp = cur.next[word.charAt(i) - 'a'] == null ? new Node() : cur.next[word.charAt(i) - 'a'];
            cur.next[word.charAt(i) - 'a'] = tmp;
            cur = tmp;
        }
        cur.endFlag = true;
    }

    boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    void dfs(int x, int y, char[][] board, StringBuilder word, Node cur) {
        if (cur.endFlag) {
            ans.add(word.toString());
        }

        for (int i = 0; i < 4; i ++) {
            int nx = x + DIR[i][0], ny = y + DIR[i][1];
            if (check(nx, ny) && !vis[nx][ny]) {
                char c = board[nx][ny];
                if (cur.next[c - 'a'] != null) {
                    vis[nx][ny] = true;
                    word.append(c);
                    dfs(nx, ny, board, word, cur.next[c - 'a']);
                    word.deleteCharAt(word.length() - 1);
                    vis[nx][ny] = false;
                }
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;
        vis = new boolean[n][m];
        for (String word : words)
            insert(word);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (root.next[board[i][j] - 'a'] != null) {
                    vis[i][j] = true;
                    dfs(i, j, board, new StringBuilder(String.valueOf(board[i][j])), root.next[board[i][j] - 'a']);
                    vis[i][j] = false;
                }
            }
        }
        return new ArrayList<>(ans);
    }

}
