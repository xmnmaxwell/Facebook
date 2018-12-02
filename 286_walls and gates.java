286. walls and gates
Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

   public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0 || rooms == null) return;
        int n = rooms[0].length;
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};// define the four connected coordinator
        
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();// create two queue to store the coordination
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0){
                    qx.offer(i);
                    qy.offer(j); // store all the room coordination in the queue;
                }
            }
        }
        
        while (!qx.isEmpty()){
            int cx = qx.poll();
            int cy = qy.poll();// poll the room or gate from the queue
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i]; // find its up down left right elements
                
                if (nx < m && ny < n && nx >= 0 && ny >= 0 && rooms[nx][ny] == Integer.MAX_VALUE){
                    qx.offer(nx);
                    qy.offer(ny);
                    rooms[nx][ny] =rooms[cx][cy] + 1;
                }
            } 
        } 
    }
