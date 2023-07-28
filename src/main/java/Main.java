public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.createEmployees();
        System.out.println("Общая зарплата: " + company.getWage());
        company.outputConsole(company.getListEmployees());
        company.sortMinMaxSalary(company.getListEmployees());
        company.sortMaxMinSalary(company.getListEmployees());
    }
}
