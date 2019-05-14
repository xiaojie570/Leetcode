package leetcode.array.backtracking;

/**
 * Created by lenovo on 2019/5/14.
 * 在二维数组里搜索是否存在给定的单词
 */
public class _79_Word_Search {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;
        if(word == null)
            return true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(help(board,visited,i,j,word,0))
                    return true;
            }
        }
        return false;
    }

    private boolean help(char[][] board, boolean[][] visited, int i, int j, String word,int index) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
                return false;
        }
        if(index == word.length() - 1)
            return true;
        visited[i][j] = true;
        if(help(board,visited, i + 1, j, word, index + 1) ||
                help(board, visited, i - 1, j, word, index + 1) ||
                help(board, visited, i, j + 1, word, index + 1) ||
                help(board, visited, i, j - 1, word, index + 1))
            return true;
        visited[i][j] =false;
        return false;
    }
}
