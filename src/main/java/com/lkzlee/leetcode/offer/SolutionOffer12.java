package com.lkzlee.leetcode.offer;

/**
 * @version: 1.0
 * @author: lkzlee
 * @date: 2020/10/10 17:10
 * @desc: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [['a','b','c','e'],
 * ['s','f','c','s'],
 * ['a','d','e','e']]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [['a','b'],['c','d']], word = 'abcd'
 * 输出：false
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionOffer12 {
    int[][] direct = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0 || board[0] == null || board[0].length <= 0) return false;
        if (word == null || word.length() <= 0) return false;

        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean flag = doSearchBackTracking(board, word, mark, i, j);
                if (flag) return true;
            }
        }
        return false;
    }

    private boolean doSearchBackTracking(char[][] board, String word, boolean[][] mark, int i, int j) {
        if (word.length() == 0) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(0)) return false;
        if (mark[i][j]) return false;
        mark[i][j] = true;
        for (int[] dt : direct) {
            int x = i + dt[0];
            int y = j + dt[1];
            boolean flag = doSearchBackTracking(board, word.substring(1), mark, x, y);
            if (flag) return true;
        }
        mark[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean rs = new SolutionOffer12().exist(board, word);
        System.out.println(rs);
    }
}
