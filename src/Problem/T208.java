package Problem;

public class T208 {

    final static int LEN = 26;

    static class Node{
        boolean endFlag;
        Node[] next;
        Node() {
            next = new Node[LEN];
            endFlag = false;
        }
    }
    Node root;

    public T208() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            Node tmp = cur.next[word.charAt(i) - 'a'] == null ? new Node() : cur.next[word.charAt(i) - 'a'];
            cur.next[word.charAt(i) - 'a'] = tmp;
            cur = tmp;
        }
        cur.endFlag = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            cur = cur.next[word.charAt(i) - 'a'];
            if (cur == null) {
                return false;
            }
        }
        return cur.endFlag;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i ++) {
            cur = cur.next[prefix.charAt(i) - 'a'];
            if (cur == null) {
                return false;
            }
        }
        return true;
    }

}
