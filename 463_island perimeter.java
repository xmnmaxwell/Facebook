463. island perimeter 给定岛和水计算岛的周长
class Solution {
    //思路就是搜索每个方形再搜索他的下面和右面是否为1是的话就多加了两条边，最后的公式是4*总方块数-2*下和右neighbour的方块数
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;
        
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    islands++;   
                if (i < grid.length - 1 && grid[i+1][j] == 1) 
                    neighbours++;
                if (j < grid[0].length - 1 && grid[i][j+1]== 1)
                    neighbours++;
                }    
        }
    }
        return 4 * islands - 2 * neighbours;
    }    
}
