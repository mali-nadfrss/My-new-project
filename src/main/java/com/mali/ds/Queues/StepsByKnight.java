package com.mali.ds.Queues;

import java.util.ArrayDeque;
import java.util.Queue;

/* https://practice.geeksforgeeks.org/problems/steps-by-knight5927
 * medium geeks
 * */
class Position {
    int x;
    int y;
    int dis;

    Position(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class StepsByKnight {

    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        // Code here
        int[] xLeg = {1, 2, -2, -1, 2, 1, -2, -1};
        int[] yLeg = {2, 1, 1, 2, -1, -2, -1, -2};

        Queue<Position> q = new ArrayDeque<>();
        int[][] visited = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = 0;
            }
        }
        q.add(new Position(KnightPos[0], KnightPos[1], 0));
        Position current = null;

        while (!q.isEmpty()) {
            current = q.poll();
            if (TargetPos[0] == current.x && TargetPos[1] == current.y) {
                return current.dis;
            }
            for (int i = 0; i < 8; i++) {
                int tempX = current.x + xLeg[i];
                int tempY = current.y + yLeg[i];
                if (isInside(tempX, tempY, N) && visited[tempX][tempY] != 1) {
                    q.add(new Position(tempX, tempY, current.dis + 1));
                    visited[tempX][tempY] = 1;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static boolean isInside(int x, int y, int N) {
        return x <= N && y <= N && x > -1 && y > -1;
    }

    public static void main(String[] args) {
        System.out.print(minStepToReachTarget(new int[]{1, 1}, new int[]{7, 5}, 7));
    }

}
