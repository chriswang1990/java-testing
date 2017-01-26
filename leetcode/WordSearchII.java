package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by cwang on 1/25/2017.
 */
public class WordSearchII {

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        HashSet<String> set = new HashSet<String>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String cur = "";
                bfs(set, cur, trie.root, board, visited, i, j);
            }
        }
        return new ArrayList<String>(set);
    }

    public void bfs(HashSet<String> set, String cur, TreeNode node, char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        int pos = board[i][j] - 'a';
        if (node.nodes[pos] == null) {
            return;
        }
        visited[i][j] = true;
        cur += board[i][j];
        if (node.nodes[pos].isWord) {
            set.add(cur);
        }
        int[][] dirs = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        for (int[] dir : dirs) {
            bfs(set, cur, node.nodes[pos], board, visited, i + dir[0], j + dir[1]);
        }
        visited[i][j] = false;
    }

    class Trie {
        TreeNode root;
        public Trie() {
            root = new TreeNode();
        }

        public void insert(String s) {
            int len = s.length();
            TreeNode cur = root;
            for (int i = 0; i < len; i++) {
                int pos = s.charAt(i) - 'a';
                if (cur.nodes[pos] == null) {
                    cur.nodes[pos] = new TreeNode();
                }
                cur = cur.nodes[pos];
            }
            cur.isWord = true;
        }
    }

    class TreeNode {
        boolean isWord;
        TreeNode[] nodes;
        public TreeNode() {
            isWord = false;
            nodes = new TreeNode[26];
        }
    }

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = {
                {'d', 'o', 'a', 'f'},
                {'a', 'g', 'a', 'i'},
                {'d', 'c', 'a', 'n'}
        };
        ArrayList<String> words = new ArrayList<>(Arrays.asList("dog","dad","dgdg","can","again"));
        System.out.println(wordSearchII.wordSearchII(board, words).toString());
    }
}
