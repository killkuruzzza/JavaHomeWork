import employees.Employee8Hour;
import employees.EmployeeFree;
import employees.EmployeeMonth;
import employees.SuperEmployees;
import lombok.Getter;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Company {
    private final List<SuperEmployees> listEmployees = new ArrayList<>();

    public double getWage() {
        double wage = 0;
        for (SuperEmployees superEmployees : listEmployees)
            wage += superEmployees.getSalary();
        return wage;
    }

    public void createEmployees() {
        listEmployees.add(new EmployeeMonth("Иван", "Петров", 3000));
        listEmployees.add(new EmployeeMonth("Петр", "Данилов", 2000));
        listEmployees.add(new Employee8Hour("Данил", "Сергеев", 85));
        listEmployees.add(new Employee8Hour("Сергей", "Иванов", 75));
    }

    public void outputConsole(List<SuperEmployees> employeesList) {
        String employeer = null;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i) instanceof EmployeeMonth)
                employeer = "дневной";
             else if (employeesList.get(i) instanceof EmployeeFree)
                employeer = "фриланс";
             else if (employeesList.get(i) instanceof Employee8Hour)
                employeer = "почасовой";

            System.out.println(i + 1 + " " + employeesList.get(i).getName() + " " + employeesList.get(i).getFamily() + " " + employeer + " " + employeesList.get(i).getSalary());
        }
    }

    public void sortMinMaxSalary(List<SuperEmployees> employeesList) {
        System.out.println();
        System.out.println("Сортировка от минимума к максимуму");
        employeesList.sort(Comparator.comparingDouble(SuperEmployees::getSalary));
        outputConsole(employeesList);
    }

    public void sortMaxMinSalary(List<SuperEmployees> employeesList) {
        System.out.println();
        System.out.println("Сортировка от максимуму к минимуму");
        employeesList.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        outputConsole(employeesList);
    }

    public void saveFile(String link) {
        try {
            FileWriter writer = new FileWriter(link, false);
            writer.write(listEmployees.size() + "\n");
            for (SuperEmployees value : listEmployees) {
                writer.write(value.getClass().getSimpleName() + "\n");
                writer.write(value.getName() + "\n");
                writer.write(value.getFamily() + "\n");
                if (value.getClass().getSimpleName().equals("EmployeeMonth"))
                    writer.write((((EmployeeMonth) value).getPriceMounts()) + "\n");

                if (!value.getClass().getSimpleName().equals("EmployeeMonth"))
                    writer.write((((Employee8Hour) value).getHourPrice()) + "\n");

                if (value.getClass().getSimpleName().equals("EmployeeFree"))
                    writer.write((((EmployeeFree) value).getHourDay()) + "\n");

            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}