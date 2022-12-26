package com.mali.game.theory;

/* https://leetcode.com/problems/guess-the-word/description/ */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Master {
  int guess(String word) {
    return GuessTheWord.match(word, "secret");
  }
}

public class GuessTheWord {

  public void findSecretWord(String[] words, Master master) {

    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      String currentGuess = words[random.nextInt(words.length)];
      int count = master.guess(currentGuess);
      List<String> currentList = new ArrayList<>();
      for (String word : words) {
        if (match(word, currentGuess) == count) {
          currentList.add(word);
        }
      }
      words = currentList.toArray(new String[0]);
    }
  }

  public static int match(String a, String b) {
    int ans = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == b.charAt(i)) {
        ans++;
      }
    }
    return ans;
  }
}
