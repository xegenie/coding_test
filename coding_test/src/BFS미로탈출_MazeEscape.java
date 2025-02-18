import java.util.*;

public class BFS미로탈출_MazeEscape {
    // 이동 방향 (상, 하, 좌, 우)
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int bfs(int[][] maze) {
        int n = maze.length, m = maze[0].length;
        Queue<int[]> queue = new LinkedList<>(); // BFS 탐색을 위한 큐
        queue.add(new int[]{0, 0, 1}); // (x, y, 이동 횟수)
        boolean[][] visited = new boolean[n][m]; // 방문 여부 체크
        visited[0][0] = true; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], count = curr[2];

            if (x == n - 1 && y == m - 1) return count; // 목표 지점 도착 시 최소 거리 반환

            // 4방향 탐색
            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];

                // 미로 범위 내에 있고, 벽이 아니며, 방문하지 않은 곳이라면 이동
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, count + 1});
                    visited[nx][ny] = true; // 방문 처리
                }
            }
        }
        return -1; // 목표 지점까지 갈 수 없는 경우
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1}
        };
        System.out.println(bfs(maze)); // → 7
    }
}
