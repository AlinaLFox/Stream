package employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;

public class Employee {

    //definim variabile
    public String name;
    public int age;
    public boolean isPayedPerHour;
    public String department;

    //metodele getter si setter pentru variabile de mai sus(pentru folosirea in operatiuni intermediare in stream
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPayedPerHour() {
        return isPayedPerHour;
    }

    public void setPayedPerHour(boolean payedPerHour) {
        isPayedPerHour = payedPerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //contructor
    public Employee(String name, int age, boolean isPayedPerHour, String department) {
        this.name = name;
        this.age = age;
        this.isPayedPerHour = isPayedPerHour;
        this.department = department;
    }

    //equals pentru gasirea duplicatelor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age && isPayedPerHour == employee.isPayedPerHour && name.equals(employee.name) && department.equals(employee.department);
    }

    //criteriu de gruparea obiectelor
    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    //fara aceasta metoda obiectele finale nu vor fi afisate la parcurgerea codului
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isPayedPerHour=" + isPayedPerHour +
                ", department='" + department + '\'' +
                '}';
    }

    public boolean canAttendTraining() {
        return department.equals("Software") || department.equals("Management");
    }

    public boolean canLeadInterview () {
        return age >= 25;
    }
    }
