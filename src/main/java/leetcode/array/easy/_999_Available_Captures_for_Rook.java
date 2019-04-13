package leetcode.array.easy;

/**
 * Created by lenovo on 2019/4/13.
 * 象棋（签到题）
 */
public class _999_Available_Captures_for_Rook {
    public int numRookCaptures(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return 0;
        int x = 0 ,y = 0;
        int ret = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j <board[0].length;j++) {
                if(board[i][j] == 'R'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        ret += retNum(board,x,y,1,0); // 下面
        ret += retNum(board,x,y,-1,0); // 上面
        ret += retNum(board,x,y,0,-1); // 左面
        ret += retNum(board,x,y,0,1); // 右面
        return ret;
    }
    private int retNum(char[][] board, int x,int y,int row_step,int col_step) {
        int ret = 0;
        while(x < board.length && x >= 0 && y < board[0].length && y >= 0) {
            if(board[x][y] == 'B') break;
            else if(board[x][y] == 'p') {
                ret += 1;
                break;
            }
            x += row_step;
            y += col_step;
        }
        return ret;
    }
}
