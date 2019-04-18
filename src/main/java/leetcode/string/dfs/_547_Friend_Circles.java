package leetcode.string.dfs;

/**
 * Created by lenovo on 2019/4/18.
 */
public class _547_Friend_Circles {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0] == null || M[0].length == 0)
            return 0;
        int length = M.length;
        boolean [] visited = new boolean[length];
        int ret = 0;
        for(int i = 0; i < length;i ++) {
            if (!visited[i]) {
                ret++;
                dfs(M, i, visited);
            }
        }
        return ret;
    }

    private void dfs(int[][] M, int id, boolean[] visited) {
        if(visited[id]) return;
        visited[id] = true;
        int friends[] = M[id];
        for(int i = 0; i < friends.length; i++) {
            if(i == id) continue;
            if(friends[i] == 1 && !visited[i])
                dfs(M,i,visited);
        }
    }
}
