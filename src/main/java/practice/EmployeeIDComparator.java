package practice;

import java.util.Comparator;

public class EmployeeIDComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getID().compareTo(o2.getID());
    }
}
