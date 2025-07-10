package algorithm.test.baekjoon.solved.No14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

        static int N, M;
        static int[][] map;       // 원본 지도 정보
        static int[][] dist;      // 결과 출력용 거리 저장
        static boolean[][] visited;
        static int[] dx = {-1, 1, 0, 0}; // 상하좌우
        static int[] dy = {0, 0, -1, 1};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 행
            M = Integer.parseInt(st.nextToken()); // 열

            map = new int[N][M];
            dist = new int[N][M];
            visited = new boolean[N][M];

            int startX = 0, startY = 0;

            // 지도 입력 받기 + 시작점 찾기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            // BFS로 거리 구하기
            bfs(startX, startY);

            // 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        sb.append(0).append(" ");
                    } else if (!visited[i][j]) {
                        sb.append(-1).append(" ");
                    } else {
                        sb.append(dist[i][j]).append(" ");
                    }
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }

        static void bfs(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x, y});
            visited[x][y] = true;
            dist[x][y] = 0;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int cx = now[0];
                int cy = now[1];

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (!visited[nx][ny] && map[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            dist[nx][ny] = dist[cx][cy] + 1;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }