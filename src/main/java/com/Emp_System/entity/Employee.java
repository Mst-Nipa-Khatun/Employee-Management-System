package com.Emp_System.entity;

import jakarta.persistence.*;

@Entity //first of all this is a entity class, then in this class we declare some variable or entity that we used all class.
@Table(name = "emp_system") // this is a table name declare annotation.this table name we used in DB.
public class Employee {
    @Id        //Id annotation for auto generated id.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key should be auto-generated by the database,auto-incremented value.
                                                         //Identity-unique identifier generated by itself in DB.
    //private variable declare
    private Integer id;
    private String name;
    private String address;
    private Double salary;
    private String email;
    private String phno;

    //no arguement constructor
    public Employee() {
    }

    //all variable generate in getter & setter.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
