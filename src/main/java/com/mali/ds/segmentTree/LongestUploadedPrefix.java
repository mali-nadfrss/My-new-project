package com.mali.ds.segmentTree;

/*https://leetcode.com/problems/longest-uploaded-prefix/description/ */
public class LongestUploadedPrefix {

  int tot = 0;
  boolean[] tree;

  LongestUploadedPrefix(int n) {
    tot = n;
    tree = new boolean[4 * n];
  }

  public static void main(String[] args) {
    LongestUploadedPrefix lup = new LongestUploadedPrefix(4);
    lup.upload(3);
    lup.longest();
    lup.upload(1);
    lup.longest();
    lup.upload(2);
    lup.longest();
  }

  void update(int video, int node, int st, int en) {
    if (st == en) {
      if (st == video) tree[video] = true;
      return;
    }
    int mid = (st + en) / 2;
    if (video <= mid) {
      update(video, 2 * node, st, en);
    } else {
      update(video, 2 * node + 1, st, en);
    }
    tree[node] = tree[2 * node] & tree[2 * node + 1];
  }

  int query(int node, int st, int en) {

    if(st == en){
      return tree[st] ? 1 : 0;
    }
    if(tree[node]){
      return st;
    }

    int mid = (st+en)/2;
    return 1;//tree[2*node] ==0 ? query(2*node, st, mid);

  }

  void upload(int video) {
    update(video, 1, 1, tot);
  }

  int longest() {
    return query(1, 1, tot);
  }
}
