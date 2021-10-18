package programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortObjectsUsingComparatorExample {

  public static void main(String[] args) {

    //arraylist of Employee objects
    ArrayList<Employee> aListEmployee = new ArrayList<Employee>();

    //add employee objects to ArrayList
    aListEmployee.add( new Employee("1", "Mark", "Marketing", 45) );
    aListEmployee.add( new Employee("2", "Lucy", "Customer Care", 24) );
    aListEmployee.add( new Employee("3", "Brinda", "Public Relations", 37) );
    aListEmployee.add( new Employee("4", "Raj", "IT", 22) );

    /*
     * To sort an ArrayList of custom objects, use sort method of Collections class
     * along with the custom Comparator ojbect we created.
     */

    Collections.sort(aListEmployee, new EmployeeComparator());

    System.out.println(aListEmployee);

  }
}


class EmployeeComparator implements Comparator<Employee>{

  /*
   * Compare method should return zero for equal values, positive integer if
   * value 1 is greater than value 2 and negative value if value 2 is less than
   * value 2 to sort objects in ascending order.
   */
  public int compare(Employee emp1, Employee emp2){

    //compare age of employees

    //if emp1 age is greater than emp2 age, return 1
    if( emp1.getAge() > emp2.getAge() ){
      return 1;
      //if emp1 age is less than emp2 age, return -1
    }else if( emp1.getAge() < emp2.getAge() ){
      return -1;
      //if equal
    }else{
      return 0;
    }

  }

}
