package com.example.lab_2;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Adam", "Jones"); // new Employee object emp1
        System.out.println("Employee ID: " + emp1.getEmp_id());
        System.out.println("First name: " + emp1.getFirstname());
        System.out.println("Last name: " + emp1.getLastname());

        emp1.setFirstname("Ben"); // Update first name
        emp1.setLastname("Waltham"); // Update last name
        System.out.println("----------------- Updated First and Last name -----------------");
        System.out.println("Employee ID: " + emp1.getEmp_id());
        System.out.println("First name: " + emp1.getFirstname());
        System.out.println("Last name: " + emp1.getLastname());

    }
}

class Employee {
    private int emp_id; // Employee ID - int
    private String firstname; // First name - String
    private String lastname; // Last name - String

    // Constructor taking Employee info from parmas
    Employee(int emp_id, String firstname, String lastname) {
        this.emp_id = emp_id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // public getters
    public int getEmp_id() {
        return emp_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    // public setters
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}