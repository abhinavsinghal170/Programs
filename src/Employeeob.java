import java.util.*;
import java.util.stream.Collectors;

public class Employeeob {

    public static  List<Employee> init(){
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1,"Abhinav", 23, "Male", "Account", 25000));
        emp.add(new Employee(10,"Abhinav", 26, "Male", "Account", 25000));
        emp.add(new Employee(2,"ashok", 27, "Female", "HR", 30000));
        emp.add(new Employee(3,"amey", 5, "Male", "doctor", 38000));
        emp.add(new Employee(4,"devansh", 8, "Male", "Account", 28000));
        emp.add(new Employee(5,"shefali", 28, "Female", "Operator", 21000));
        emp.add(new Employee(6,"lakshay", 25, "Male", "Account", 56000));
        emp.add(new Employee(7,"nirmal", 24, "Female", "HR", 65000));
        emp.add(new Employee(8,"shivam", 26, "Male", "doctor", 79000));
        emp.add(new Employee(9,"deeepak", 29, "Female", "Account", 89000));

        return emp;
    }

    public static void main(String[] args){
        List<Employee> list = init();
        List a = list.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getId)).collect(Collectors.toList());
        System.out.println(a);

        System.out.println("---------------------------------------------------");
        Map<String, Employee> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                        , Optional::get)));
        /*Set<Map.Entry<String, Employee>> set = map.entrySet();
        for (Map.Entry<String, Employee> a : set){
            System.out.println(a.getKey() + " = " + a.getValue());
        }*/
        //map.entrySet().iterator().forEachRemaining(System.out::println);
        map.forEach((Key, Value) -> {
            System.out.println(Key);
            System.out.println(Value);
        });

        Map<String, Double> map1 = list.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.averagingDouble(Employee::getSalary)));
        map1.entrySet().iterator().forEachRemaining(System.out::println);
    }
}
