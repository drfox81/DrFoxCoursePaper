import java.sql.Array;
import java.util.Objects;

public class Employee {
    private String worker;
    private int departament;
    private int salary;
    private static int counter = 1;
    private int id;

    //private static Employee[] employee = new Employee[10];

    public Employee(String worker, int departament, int salary) {
        this.worker = worker;
        this.departament = departament;
        this.salary = salary;
        this.id = counter;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getWorker() {
        return this.worker;
    }

    public int getId() {
        return id;
    }

    public String setWorker(String worker) {
        return this.worker;
    }

    public int getDepartament() {
        return this.departament;
    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник - " + worker +
                "  работает в отделе № "
                + departament + " с заработной платой "
                + salary + " рублей. || ID: " + id;
    }

    //печатаем список сотрудников
    public static void listName(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                System.out.println(employee[i].getWorker());
            }
        }
        return;
    }

    // вывод списка сотрудников с зарплатой меньше от определенного уровня
    public static void salaryDown(Employee[] employees, int level) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < level) {
                System.out.println("Сотрудник - " + employees[i].getWorker() + ", оклад - "
                        + employees[i].getSalary() + " рублей.  || ID " + employees[i].getId());
            }
        }
    }

    // вывод списка сотрудников с зарплатой больше или равно от определенного уровня
    public static void salaryUp(Employee[] employees, int level) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= level) {
                System.out.println("Сотрудник - " + employees[i].getWorker() + ", оклад - "
                        + employees[i].getSalary() + " рублей.  || ID " + employees[i].getId());
            }
        }
    }

    //вывод сотрудников конкретного отдела (ФИО, оклад)
    public static void listDepartament(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("Сотрудник - " + employees[i].getWorker() + ", оклад - "
                        + employees[i].getSalary() + " рублей.");
            }
        }
    }

    //Изменение зарплаты на хх%
    public static void upSalaryPercent(Employee[] employee, int percent) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                employee[i].setSalary(employee[i].getSalary() * (100 + percent) / 100);
            }
        }
    }

    //вывод списка сотркдников

    //Вывод средней зарплаты в компании
    public static void avarageSalary(Employee[] employee) {
        int sumPerson = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                sumPerson += 1;
            }
        }
        System.out.println("Средняя зарплата равна - "
                + amountOfSalarisMounth(employee) / sumPerson + " рублей.");
    }


    //Разделитель вывода
    public static void newChapter() {
        System.out.println("=============================================================================");
    }

    //Поиск сотрудника с максимальной зп
    public static void maxSalary(Employee[] employee) {
        int buffer = 0;
        int numberEmployee = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                buffer = employee[i].getSalary();
                for (; i < employee.length - 1; i++) {
                    if (employee[i + 1] != null) {
                        if (buffer < employee[i + 1].getSalary()) {
                            buffer = employee[i + 1].getSalary();
                            numberEmployee = i + 1;
                        }
                    }
                }
                System.out.println("Сотрудник с максимальной зарплатой - " + employee[numberEmployee].getWorker() +
                        ", размер зарплаты равен - " + employee[numberEmployee].getSalary() + " рублей.");
            }
        }

    }

    //Поиск сотрудника с минимальной зп
    public static void minSalary(Employee[] employee) {
        int buffer = 0;
        int numberEmployee = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                buffer = employee[i].getSalary();
                for (; i < employee.length - 1; i++) {
                    if (employee[i + 1] != null) {
                        if (buffer > employee[i + 1].getSalary()) {
                            buffer = employee[i + 1].getSalary();
                            numberEmployee = i + 1;
                        }
                    }
                }
                System.out.println("Сотрудник с минимальной зарплатой - " + employee[numberEmployee].getWorker() +
                        ", размер зарплаты равен - " + employee[numberEmployee].getSalary() + " рублей.");
                return;
            }
        }
    }

    //Зарплатный фонд компании
    public static int amountOfSalarisMounth(Employee[] employee) {
        int sumSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                sumSalary += employee[i].getSalary();
            }
        }
        return sumSalary;
    }


    //Вывод списка сотрудника со всеми свойствами
    public static void list(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                System.out.println(employee[i].toString());
            }
        }
    }

    //отбор сотрудников по параметру - отдел (departament)
    public Employee[] departamentNumber(Employee[] employees, int departament) {
        Employee[] employees1 = new Employee[employees.length];
        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartament() == departament) {
                employees1[j] = employees[i];
                j++;
            }
        }
        return employees1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(worker, employee.worker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worker, id);
    }

    public Employee() {
    }
}