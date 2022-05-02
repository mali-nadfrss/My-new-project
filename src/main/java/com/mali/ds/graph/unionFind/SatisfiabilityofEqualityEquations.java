package com.mali.ds.graph.unionFind;

/* https://leetcode.com/problems/satisfiability-of-equality-equations/
 * medium */
public class SatisfiabilityofEqualityEquations {

  // logic is to union when equation has ==
  // then loop again to check if everyone's parent(we found earlier) is equal or not
  public static boolean equationsPossible(String[] equations) {
    char[] parent = new char[26];
    for (int i = 0; i < 26; i++) {
      // initially everyone has itself as parent
      parent[i] = (char) ('a' + i);
    }
    for (String equation : equations) {
      if (equation.contains("==")) {
        // make union only in case of ==
        union(parent, equation.charAt(0), equation.charAt(3));
      }
    }
    for (String equation : equations) {
      if (equation.contains("==")) {
        // case1 : both parents should be equal
        if (find(parent, equation.charAt(0)) != find(parent, equation.charAt(3))) {
          return false;
        }
      }
      if (equation.contains("!=")) {
        // case 2 : both parents shouldn't be equal
        if (find(parent, equation.charAt(0)) == find(parent, equation.charAt(3))) {
          return false;
        }
      }
    }
    return true;
  }

  // classic union method
  static void union(char[] parent, char i, char j) {

    // find parent for char at 0
    char iParent = find(parent, i);
    // find parent for char at 3
    char jParent = find(parent, j);
    if (iParent > jParent) {
      // assign new  parent to iParnet but not i
      parent[jParent - 'a'] = iParent;
    } else if (jParent > iParent) {
      // assign new  parent to jParnet but not j
      parent[iParent - 'a'] = jParent;
    }
  }

  static char find(char[] parent, char c) {
    if (parent[c - 'a'] != c) {
      // recursive logic to get final parent
      parent[c - 'a'] = find(parent, parent[c - 'a']);
    }
    // always return parent not c
    return parent[c - 'a'];
  }

  public static void main(String[] args) {

    String[] c = new String[] {"d!=f", "f==e", "a==b", "a==c"};
    System.out.println(equationsPossible(c));
  }
}
