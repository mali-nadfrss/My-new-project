package com.mali.ds.dp.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

  static class Item {
    int value, weight;

    Item(int x, int y) {
      this.value = x;
      this.weight = y;
    }
  }

  static double fractionalKnapsack(int W, Item arr[], int n) {

    Arrays.sort(arr, Comparator.comparingDouble(o -> -(double) o.value / o.weight));
    double ans = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i].weight >= W) {
        ans += ((double) W / arr[i].weight) * arr[i].value;
        return ans;
      } else {
        W -= arr[i].weight;
        ans += arr[i].value;
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    int N = 3, W = 50;
    int values[] = {60, 100, 120};
    int weight[] = {10, 20, 30};
    Item[] arr = new Item[N];
    for (int i = 0; i < N; i++) {
      arr[i] = new Item(values[i], weight[i]);
    }

    fractionalKnapsack(W, arr, N);
  }
}
