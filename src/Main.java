import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {

        Employee[] employee = new Employee[10];

        employee[8] = new Employee("Иванов Иван Иванович1", 1, 70000);
        employee[1] = new Employee("Иванов Иван Иванович2", 1, 60000);
        employee[2] = new Employee("Иванов Иван Иванович3", 3, 70000);
        employee[3] = new Employee("Иванов Иван Иванович4", 1, 30000);
        employee[4] = new Employee("Иванов Иван Иванович5", 5, 90000);
        employee[7] = new Employee("Иванов Иван Иванович7", 1, 25000);


        Employee.list(employee);
        Employee.newChapter();
        System.out.println("Сумма зарплат за месяц равна " + Employee.amountOfSalarisMounth(employee) + " рублей.");
        Employee.newChapter();
        Employee.minSalary(employee);
        Employee.newChapter();
        Employee.maxSalary(employee);
        Employee.newChapter();
        Employee.avarageSalary(employee);
        Employee.newChapter();
        Employee.listName(employee);
        Employee.newChapter();
        Employee.list(employee);
        System.out.println("======+++++=====задания Повышенная сложность ====================");
        Employee dep = new Employee();
        Employee.upSalaryPercent(employee, 50);// увеличение зп на хх%
        Employee.minSalary(dep.departamentNumber(employee, 1));//поиск мин зп в отделе
        Employee.newChapter();
        Employee.maxSalary(dep.departamentNumber(employee, 1));//поиск макс зп в отделе
        Employee.newChapter();
        System.out.println("Сумма зарплат за месяц в отделе №" +
                dep.departamentNumber(employee, 1)[0].getDepartament() + " равна "
                + Employee.amountOfSalarisMounth(dep.departamentNumber(employee, 1)) + " рублей.");//сумма затрат на зп в отделе в месяц
        Employee.newChapter();
        Employee.list(dep.departamentNumber(employee, 1));//список сотрудников в отделе ФИО, отдел, зп
        Employee.newChapter();
        Employee.avarageSalary(dep.departamentNumber(employee, 1));//средняя зп в отделе
        Employee.newChapter();
        Employee.upSalaryPercent(dep.departamentNumber(employee, 1), 30);//увеличение суммы оклада в тделе на хх%
        Employee.newChapter();
        Employee.listDepartament(dep.departamentNumber(employee, 1));//вывод списка сотрудников в отделе - ФИО, зп
        Employee.newChapter();
        Employee.salaryUp(employee, 70000);//вывод списка сотрудников с зп выше уровня
        Employee.newChapter();
        Employee.salaryDown(employee, 70000);//вывод списка сотрудников с зп ниже уровня



    }


}


