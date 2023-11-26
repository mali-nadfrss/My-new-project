package practice;

import java.util.List;

public class Vote {


  public List<String> getCandidates() {
    return candidates;
  }

  private List<String> candidates;

  public Vote(List<String> candidates) {
    this.candidates = candidates;
  }
}
