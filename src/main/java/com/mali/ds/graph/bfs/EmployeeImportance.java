package com.mali.ds.graph.bfs;

import com.mali.oops.Manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* https://leetcode.com/problems/employee-importance/
 * medium */
public class EmployeeImportance {
  static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    Employee(int id, int importance, int[] subs) {
      this.id = id;
      this.importance = importance;
      this.subordinates = new ArrayList<>();
      for (int i : subs) {
        subordinates.add(i);
      }
    }

    public Employee() {

    }
  }

  public static int getImportance(List<Employee> employees, int id) {
    int[][] grid = new int[2001][2001];
    for (Employee e : employees) {
      grid[e.id][e.id] = e.importance;
      for (int i : e.subordinates) {
        grid[e.id][i] = 1;
      }
    }
    int ans = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(id);

    while (!q.isEmpty()) {
      int k = q.poll();
      ans += grid[k][k];
      for (int i = 0; i < 2001; i++) {
        if (k != i && grid[k][i] == 1) {
          q.add(i);
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    List<Employee> list = new ArrayList<>();
    Employee e = new Employee(1, 5, new int[] {2, 3});
    Employee e1 = new Employee(2, 3, new int[] {});
    Employee e2 = new Employee(3, 3, new int[] {});
    list.add(e);
    list.add(e1);
    list.add(e2);

    Manager man1 = new Manager();
    Manager man3 = new Manager();
    Manager man2 = new Manager();

    man1.id = 2;

    System.out.println(getImportance(list, 1));
  }
}
