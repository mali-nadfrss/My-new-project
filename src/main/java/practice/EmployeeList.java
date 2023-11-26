package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EmployeeList {

  public static void main(String[] args) {

    List<Employee> listEmp = new ArrayList<>();
    Random r = new Random();

    String name = "";
    for (int i = 0; i < 5; i++) {
      Employee e = new Employee(r.nextInt(), name + r.nextInt(), r.nextDouble());
      listEmp.add(e);
    }
    Collections.sort(listEmp, new EmployeeIDComparator());
    System.out.println("comparator" + listEmp);
    listEmp.stream().sorted().collect(Collectors.toList());
    System.out.println(listEmp);

    System.out.println("---------------------");
    // functional interface for arithmetic operations

  }
}
