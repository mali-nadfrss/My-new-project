package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamProblem {

  public static void main(String[] args) {
    List<String> strings =
        Arrays.asList("apple", "banana", "orange", "avocado", "grape", "apricot");
    Service svc = new Service();
    System.out.println(svc.convertUpperCase(strings));
    System.out.println(svc.groupStrings(strings));
  }
}

class Service {

  List<String> convertUpperCase(List<String> input) {
    return input.stream().map(String::toUpperCase).collect(Collectors.toList());
  }

  Map<Character, List<String>> groupStrings(List<String> input) {
    return input.stream().collect(Collectors.groupingBy(a -> a.charAt(0)));
  }
}
