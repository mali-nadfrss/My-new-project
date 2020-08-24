package com.mali.ds;

import java.util.ArrayList;

public class ValidPath {

    static boolean isValid(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] visited = new int[A + 1][B + 1];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                visited[i][j] = 0;
            }
        }
        for (int i = 0; i < E.size(); i++) {
            for (int j = 0; j < D; j++) {
                int k = E.get(i) + j;
                int l = F.get(i) + j;
                if (k - 1 >= 0 && l - 1 >= 0 && k - 1 <= A && l - 1 <= B) {
                    visited[k - 1][l - 1] = 1;
                }
                if (k - 1 >= 0 && l >= 0 && k - 1 <= A && l <= B) {
                    visited[k - 1][l] = 1;
                }
                if (k - 1 >= 0 && l + 1 >= 0 && k - 1 <= A && l + 1 <= B) {
                    visited[k - 1][l + 1] = 1;
                }
                if (k >= 0 && l - 1 >= 0 && k <= A && l - 1 <= B) {
                    visited[k][l - 1] = 1;
                }
                if (k >= 0 && l + 1 >= 0 && k <= A && l + 1 <= B) {
                    visited[k][l + 1] = 1;
                }
                if (k + 1 >= 0 && l - 1 >= 0 && k + 1 <= A && l - 1 <= B) {
                    visited[k + 1][l - 1] = 1;
                }
                if (k + 1 >= 0 && l >= 0 && k + 1 <= A && l <= B) {
                    visited[k + 1][l] = 1;
                }
                if (k + 1 >= 0 && l + 1 >= 0 && k + 1 <= A && l + 1 <= B) {
                    visited[k + 1][l + 1] = 1;
                }
            }
        }
        boolean[][] v = new boolean[A + 1][B + 1];
        return tryDfs(visited, A, B, 0, 0, v);
    }

    static boolean tryDfs(int[][] visited, int A, int B, int k, int l, boolean[][] v) {

        if (A == k && B == l) {
            return true;
        }

        v[k][l] = true;

        if (k - 1 >= 0 && l - 1 >= 0 && k - 1 <= A && l - 1 <= B && visited[k - 1][l - 1] == 0
                && !v[k - 1][l - 1]) {
            tryDfs(visited, A, B, k - 1, l - 1, v);
        }
        if (k - 1 >= 0 && l >= 0 && k - 1 <= A && l <= B && visited[k - 1][l] == 0 && !v[k - 1][l]) {
            tryDfs(visited, A, B, k - 1, l, v);
        }
        if (k - 1 >= 0 && l + 1 >= 0 && k - 1 <= A && l + 1 <= B && visited[k - 1][l + 1] == 0 && !v[k - 1][l + 1]) {
            tryDfs(visited, A, B, k - 1, l + 1, v);
        }
        if (k >= 0 && l - 1 >= 0 && k <= A && l - 1 <= B && visited[k][l - 1] == 0 && !v[k][l - 1]) {
            tryDfs(visited, A, B, k, l - 1, v);
        }
        if (k >= 0 && l + 1 >= 0 && k <= A && l + 1 <= B && visited[k][l + 1] == 0 && !v[k][l + 1]) {
            tryDfs(visited, A, B, k, l + 1, v);
        }
        if (k + 1 >= 0 && l - 1 >= 0 && k + 1 <= A && l - 1 <= B && visited[k + 1][l - 1] == 0 && !v[k + 1][l - 1]) {
            tryDfs(visited, A, B, k + 1, l - 1, v);
        }
        if (k + 1 >= 0 && l >= 0 && k + 1 <= A && l <= B && visited[k + 1][l] == 0 && !v[k + 1][l]) {
            tryDfs(visited, A, B, k + 1, l, v);
        }
        if (k + 1 >= 0 && l + 1 >= 0 && k + 1 <= A && l + 1 <= B && visited[k + 1][l + 1] == 0 && !v[k + 1][l + 1]) {
            tryDfs(visited, A, B, k + 1, l + 1, v);
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> E = new ArrayList<Integer>();
        E.add(2);
        ArrayList<Integer> F = new ArrayList<Integer>();
        F.add(3);
        System.out.println(isValid(2, 3, 1, 0, E, F));
    }
}
