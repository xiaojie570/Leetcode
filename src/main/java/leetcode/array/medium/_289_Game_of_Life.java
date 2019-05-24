package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/24.
 * 给定一个由 0.1组成的矩阵，每一个元素表示一个细胞的存活，1—> 存活，0-> 死亡，其中下一次更新每个细胞的存活。由上、下、左、右、左上、左下、右上、右下。8个细胞决定，存活规则如下：
 * 1. 周围存活细胞小于2个，则死亡
 * 2. 周围存活细胞2个或者3个，则存活到下一次更新
 * 3. 周围存活细胞3个以上，则死亡
 * 4. 周围存活细胞3个死细胞，将会成为一个活细胞
 */
public class _289_Game_of_Life {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int numRows = board.length, numCols = board[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int liveNeigh = 0;
                if (i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1)) liveNeigh++;  // 上边
                if (i < numRows - 1 && (board[i + 1][j] == 1 || board[i + 1][j] == -1)) liveNeigh++; // 下边
                if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1)) liveNeigh++; // 左边
                if (j < numCols - 1 && (board[i][j + 1] == 1 || board[i][j + 1] == -1)) liveNeigh++; // 右边
                if (i > 0 && j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1)) liveNeigh++;  // 左上
                if (i > 0 && j < numCols - 1 && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1)) liveNeigh++; // 左下
                if (i < numRows - 1 && j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1)) liveNeigh++; // 右上
                if (i < numRows - 1 && j < numCols - 1 && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1)) liveNeigh++; // 右下
                if (board[i][j] == 1 && (liveNeigh < 2 || liveNeigh > 3)) board[i][j] = -1; // 如果或者的细胞少于2个或者大于3个，就变成死细胞
                else if (board[i][j] == 0 && liveNeigh == 3) board[i][j] = 2; // 如果死的细胞等于3个，则变成活得细胞
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}
