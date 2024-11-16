package com.mali.ds.algorithms;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

  class HuffmanNode {
    int weight;
    Character element;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(int weight, char element) {
      this.weight = weight;
      this.element = element;
    }

    HuffmanNode(int weight, HuffmanNode left, HuffmanNode right) {
      this.weight = weight;
      this.right = right;
      this.left = left;
    }
  }

  String encode(String input) {
    int[] freq = new int[99999];
    for (char c : input.toCharArray()) {
      freq[c]++;
    }
    PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
    for (int i = 0; i < 256; i++) {
      if (freq[i] > 0) pq.add(new HuffmanNode(freq[i], (char) i));
    }

    while (pq.size() > 1) {
      HuffmanNode node1 = pq.poll();
      HuffmanNode node2 = pq.poll();
      pq.add(new HuffmanNode(node1.weight + node2.weight, node1, node2));
    }
    root = pq.poll();
    table(root, "");
    String result = "";
    for (char c : input.toCharArray()) {
      result += encodeMap.get(c);
    }
    System.out.println(result);
    return result;
  }

  void table(HuffmanNode node, String value) {
    if (node.element != null) {
      encodeMap.put(node.element, value);
    } else {
      table(node.left, value + "0");
      table(node.right, value + "1");
    }
  }

  String decode(String input) {
    String ans = "";
    HuffmanNode current = root;
    for (char c : input.toCharArray()) {
      if (c == '1') {
        current = current.right;
      } else {
        current = current.left;
      }
      if (current.element != null) {
        ans += current.element;
        current = root;
      }
    }
    System.out.println(ans);
    return ans;
  }

  static Map<Character, String> encodeMap;
  static HuffmanNode root;

  public static void main(String[] args) throws IOException {

    HuffmanCoding hf = new HuffmanCoding();
    encodeMap = new HashMap<>();
    hf.decode(hf.encode("hi this is naveen"));
  }
}
