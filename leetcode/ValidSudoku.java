package leetcode;

import java.util.HashSet;

/**
 * Created by cwang on 1/20/2017.
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<Character>();
            HashSet<Character> colSet = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char rowChar = board[i][j];
                char colChar = board[j][i];
                if (rowChar != '.') {
                    if (rowSet.contains(rowChar)) {
                        return false;
                    } else {
                        rowSet.add(rowChar);
                    }
                }
                if (colChar != '.') {
                    if (colSet.contains(colChar)) {
                        return false;
                    } else {
                        colSet.add(colChar);
                    }
                }
            }
        }

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Character> set = new HashSet<Character>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char c = board[i][j];
                        if (c == '.') {
                            continue;
                        }
                        if (set.contains(c)) {
                            return false;
                        } else {
                            set.add(c);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}
        };
        System.out.println(isValidSudoku(board));
    }

}
