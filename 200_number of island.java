200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
    O(MXN) O(min(M, N))
***********************************************************************************************
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length; //设置图长
        int n = grid[0].length;//设置图宽
        int islands = 0;//设置岛的大小
        
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (grid[i][j] == '1'){//如果遇到1就开始计算所有联通的区域
                    bfs(grid, i, j);
                    islands++;//计算完成岛的数量加1
                }
            }
        }
       return islands; 
    }

    private void bfs(char[][] grid, int x, int y){
        int[] dx = {0, 1, 0, -1};//x方向变量
        int[] dy = {1, 0, -1, 0};//y方向变量
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();//xy坐标分别加上队列
        
        qx.offer(x);
        qy.offer(y);
        grid[x][y] = '0';
        while(!qx.isEmpty()){
            int cx = qx.poll();
            int cy = qy.poll();  //cx是从队列里取出的元素
            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];//nx是计算输入点的上下左右四个点
                
                if (!(nx >= 0 && nx < m && ny >=0 && ny < n)) continue;
                if (grid[nx][ny] == '1'){
                    grid[nx][ny] = '0';//已经扫过的元素要变零防止再扫一遍
                    qx.offer(nx);
                    qy.offer(ny); //把新的xy坐标放进队列里继续搜索相邻的，凡是搜索到的都标为0，这个函数是搜索所有可能的联通点
                }
            }    
        }
    }
}
************************************************************************************************************************
694.Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.

class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        Set<List<List<Integer>>> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j <grid[0].length; j++){
                if(grid[i][j] == 1){
                    List<List<Integer>> ls = bfs(grid, i, j);
                    set.add(ls);
                }
            }
        }
        return set.size();
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    List<List<Integer>> bfs(int[][] grid, int a, int b){
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        qx.offer(a);
        qy.offer(b);
        while(!qx.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();
            List<Integer> ls = new ArrayList<>();
            ls.add(x - a);
            ls.add(y - b);
            res.add(ls);
            for(int i = 0; i < 4; i++){
                int nx = x +dx[i];
                int ny = y + dy[i];
                if(nx >= 0 &&nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1){
                    grid[nx][ny] = 0;
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }
        return res;
    }
}
