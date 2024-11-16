package practice;

public class Employee {

  private final Integer ID;
  private final String name;
  private final Double salary;

  public Employee(Integer ID, String name, Double salary) {
    this.ID = ID;
    this.name = name;
    this.salary = salary;
  }

  public Integer getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public Double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
