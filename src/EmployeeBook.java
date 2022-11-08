public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    //создать сотрудника
    public void creatEmployee(String name, int departament, int salary) {
        int i = findFreeIndex();
        if (i == -1) {
            System.out.println("У нас полный штат");
        }
        employees[i] = new Employee(name, departament, salary);
    }

    public void listByDepartament() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("отдел №" + i);
            for (Employee employee : employees) {
                if (employee != null) {
                    if (employee.getDepartament() == i) {
                        System.out.println("\t" + employee.getWorker() + "||" + employee.getId());
                    }
                } else continue;
            }
        }
    }

    //удаление сотрудника
    public void removeNameEmpolyee(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getWorker().equals(name)) {
                    employees[i] = null;
                }
            } else continue;
        }
    }

    public void removeIdEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    private int findFreeIndex() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }

    //печатаем список сотрудников
    public void listName() {
        for (Employee employee1 : employees) {
            if (employee1 != null) {
                System.out.println("\t" + employee1.getWorker());
            }
        }
    }

    // вывод списка сотрудников с зарплатой меньше от определенного уровня
    public void salaryDown(int level) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < level) {
                System.out.println("Сотрудник - " + employees[i].getWorker() + ", оклад - "
                        + employees[i].getSalary() + " рублей.  || ID " + employees[i].getId());
            }
        }
    }

    // вывод списка сотрудников с зарплатой больше или равно от определенного уровня
    public void salaryUp(int level) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= level) {
                System.out.println("Сотрудник - " + employees[i].getWorker() + ", оклад - "
                        + employees[i].getSalary() + " рублей.  || ID " + employees[i].getId());
            }
        }
    }

    //вывод сотрудников конкретного отдела (ФИО, оклад)
    public void listDepartament() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("Сотрудник - " + employees[i].getWorker() + ", оклад - "
                        + employees[i].getSalary() + " рублей." + " || " + employees[i].getId());
            }
        }
    }

    //Изменение зарплаты на хх%
    public void upSalaryPercent(int percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * (100 + percent) / 100);
            }
        }
    }

    //вывод списка сотркдников

    //Вывод средней зарплаты в компании
    public void avarageSalary() {
        int sumPerson = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumPerson += 1;
            }
        }
        System.out.println("Средняя зарплата равна - "
                + amountOfSalarisMounth() / sumPerson + " рублей.");
    }

    //Поиск сотрудника с максимальной зп
    public void maxSalary() {
        int buffer = 0;
        int numberEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                buffer = employees[i].getSalary();
                for (; i < employees.length - 1; i++) {
                    if (employees[i + 1] != null) {
                        if (buffer < employees[i + 1].getSalary()) {
                            buffer = employees[i + 1].getSalary();
                            numberEmployee = i + 1;
                        }
                    }
                }
                System.out.println("Сотрудник с максимальной зарплатой - " + employees[numberEmployee].getWorker() +
                        ", размер зарплаты равен - " + employees[numberEmployee].getSalary() + " рублей.");
            }
        }

    }

    //Поиск сотрудника с минимальной зп
    public void minSalary() {
        int buffer = 0;
        int numberEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                buffer = employees[i].getSalary();
                for (; i < employees.length - 1; i++) {
                    if (employees[i + 1] != null) {
                        if (buffer > employees[i + 1].getSalary()) {
                            buffer = employees[i + 1].getSalary();
                            numberEmployee = i + 1;
                        }
                    }
                }
                System.out.println("Сотрудник с минимальной зарплатой - " + employees[numberEmployee].getWorker() +
                        ", размер зарплаты равен - " + employees[numberEmployee].getSalary() + " рублей.");
                return;
            }
        }
    }

    //Зарплатный фонд компании
    public int amountOfSalarisMounth() {
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumSalary += employees[i].getSalary();
            }
        }
        return sumSalary;
    }

    //Зарплатный фонд компании, расшарил для вставки метода для департамента Employee[] employees
    public int amountOfSalarisMounth(Employee[] employees) {
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumSalary += employees[i].getSalary();
            }
        }
        return sumSalary;
    }

    //изменение зп и/или отдела сотрудника по ФИО
    public void salaryChange(String name, int salary, int departament) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getWorker().equals(name)) {
                    employee.setSalary(salary);
                    employee.setDepartament(departament);
                }
            } else continue;
        }
    }

    //изменение зп сотрудника по ФИО
    public void salaryChange(String name, int salary) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getWorker().equals(name)) {
                    employee.setSalary(salary);
                }
            } else continue;
        }
    }


    //Вывод списка сотрудника со всеми свойствами
    public void list() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    //отбор сотрудников по параметру - отдел (departament)
    public Employee[] departamentNumber(int departament) {
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


}
