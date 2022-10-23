package com.mali.ds.design;

/* https://leetcode.com/problems/design-tic-tac-toe/
* medium */
public class TicTacToe {

  int[] columns;
  int[] rows;
  int diag = 0;
  int xDiag = 0;
  int size;

  TicTacToe(int x) {
    columns = new int[x];
    rows = new int[x];
    size = x;
  }

  // trick here is just check whatever row we have just added.. dont check for all rows everytime
  // and use +-1
  // to add values os that when size is +-n we know that we have a winner in taht row.
  // also other diagonal has column + row == size
  int move(int row, int colmn, int player) {
    int val;
    if (player == 1) val = 1;
    else val = -1;
    columns[colmn] += val;
    rows[row] += val;
    if (colmn == row) diag += val;
    if (colmn + row == size) xDiag += val;
    if (Math.abs(diag) == size
        || Math.abs(xDiag) == size
        || Math.abs(columns[colmn]) == size
        || Math.abs(rows[row]) == size) {
      return player;
    }
    return -1;
  }
}
